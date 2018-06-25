// This script implements simple routing by loading partial HTML files 
// named corresponding to fragment identifiers.

// Wrap everything in an immediately invoked function expression,
// so no global variables are introduced.
(function () {

  // Stores the cached partial HTML pages.
  // Keys correspond to fragment identifiers.
  // Values are the text content of each loaded partial HTML file.
  var partialsCache = {};


// Stores the cached partial HTML pages.
  // Keys correspond to fragment identifiers.
  // Values are the text content of each loaded partial HTML file.
  var dataCache = {};
  





// This function LOADS a JSON datamodel and caches its(from a REST endpoint maybe...)
  function getData(datakeyId, callback){

    // If the page has been fetched before,
    if(dataCache[datakeyId]) {
      console.log("found '"+datakeyId+"'' within data cache.")
      // pass the previously fetched content to the callback.
      callback(dataCache[datakeyId]);

    } else {
      console.log("No found '"+datakeyId+"' within data cache. Ajax Get underway")
      // If the page has not been fetched before, fetch it.
      $.get("data/" + datakeyId + ".json", function (datamodel) {

        // Store the fetched data in the cache.
        dataCache[datakeyId] = datamodel;

        // Pass the newly fetched data to the callback.
        callback(datamodel);
      });
    }
  }






  // Gets the appropriate content for the given fragment identifier.
  // This function implements a simple cache.
  function getContent(fragmentId, callback){

    // If the page has been fetched before,
    if(partialsCache[fragmentId]) {

      // pass the previously fetched content to the callback.
      callback(partialsCache[fragmentId]);

    } else {
      // If the page has not been fetched before, fetch it.
      $.get("views/" + fragmentId + ".html", function (content) {

        // Store the fetched content in the cache.
        partialsCache[fragmentId] = content;

        // Pass the newly fetched content to the callback.
        callback(content);
      });
    }


    
  }






  // Sets the "active" class on the active navigation link.
  function setActiveLink(fragmentId){
    $("#navbar a").each(function (i, linkElement) {
      var link = $(linkElement),
          pageName = link.attr("href").substr(1);
      if(pageName === fragmentId) {
        link.attr("class", "active");
      } else {
        link.removeAttr("class");
      }
    });
  }






  // Updates dynamic content based on the fragment identifier.
  function navigate(){

    // Isolate the fragment identifier using substr.
    // This gets rid of the "#" character.
    var fragmentId = location.hash.substr(1);


    // Set the "content" div innerHTML based on the fragment identifier.
    getContent(fragmentId, function (content) {
      $("#content").html(content);

      if (fragmentId === "ExploreView"){
        // a var to hold the JSON data model
        getData("CarsModel", function (dataModel) {
          tempData = dataModel;
            // potentially reprocess the data model if required
            // if fragmentId = 'explorerView' - return computed county summaries
            // Populate the 'countrySummmary' table from retrieved data tocreate Country based summary.
            populateCountrySummary("countrySummmaryTable", dataModel);
          });

        
    }
    });

    // Toggle the "active" class on the link currently navigated to.
    setActiveLink(fragmentId);
  }

  // If no fragment identifier is provided,
  if(!location.hash) {

    // default to #ExploreView or SearchView
    location.hash = "#SearchView";
  }


function populateCountrySummary(tableId,  data){

    var yourTableHTML = "";
        jQuery.each(data.country, function(i1,country) {

          jQuery.each(country.manufactures, function(i2,manufacturer) {

            jQuery.each(manufacturer.modelTypes, function(i3,modelType) {

              jQuery.each(modelType.models, function(i4,model) {

                  //console.log("Rendering country row" + i1 + " Country:" + country.name + " manufacturer: "+ i2 +"  " + manufacturer.name);
                  newTableRow = "<tr>";
                  newTableRow = newTableRow + "<td>" + country.name + "</td>";
                  newTableRow = newTableRow + "<td>" + manufacturer.name + "</td>";
                  newTableRow = newTableRow + "<td>" + modelType.name + "</td>";
                  newTableRow = newTableRow + "<td>" + model.name + "</td>";
                  newTableRow = newTableRow + "</tr>";

                  $("#"+tableId+"Body").append(newTableRow);

              });
            });
          });
        });

}


  // Navigate once to the initial fragment identifier.
  navigate();

  // Navigate whenever the fragment identifier value changes.
  $(window).bind('hashchange', navigate);
}());