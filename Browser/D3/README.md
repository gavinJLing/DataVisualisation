# D3 javascript  Surface Plot
Consume XML data from Perlin noise
2 things needed
* A remote web service data source - ie PerlinXML (below)
* The http served d3 Html/javascript page.

### setup XML Perlin noise service (defaults to port 8081)
A proto type service to offer ugly looking XML.
This data service has a CORS acceptance when requests are from
http://localhost:8080
So that the d3 javascript can access the remote Datasource url
without CORS issues.

```
cd ~\DataVisualisation\Datasource\perlinXML
./gradlew clean bootRun
```
Test from browser using url
```
http://localhost:8081/perlin?xCount=1&yCount=1&zCount=1

<feed xmlns="http://foo">
  <dataItems xmlns="">
    <data noiseVal="-0.25">
      <xVal>0.5</xVal>
      <yVal>0.5</yVal>
      <zVal>0.3</zVal>
    </data>
  </dataItems>
  <wstxns1:metaData xmlns:wstxns1="http://header">
    <format xmlns="">PERLIN</format>
    <xOffset xmlns="">0.5</xOffset>
    <xCount xmlns="">1</xCount>
    <xStep xmlns="">0.01</xStep>
    <yOffset xmlns="">0.5</yOffset>
    <yCount xmlns="">1</yCount>
    <yStep xmlns="">0.01</yStep>
    <zOffset xmlns="">0.3</zOffset>
    <zCount xmlns="">1</zCount>
    <zStep xmlns="">0.01</zStep>
  </wstxns1:metaData>
</feed>
```
### Setup http-server
To serve up the HTTP content to a browser

Setup Node.js http-server to serve the project via a http server.

install node.js
install http-server

```
cd ~\DataVisualisation\Browser\D3\linegraph

http-server
Note.
Starting up http-server, serving ./
Available on:
  http://192.168.1.71:8080
  http://127.0.0.1:8080
Hit CTRL-C to stop the server
```

Enables Node.js to server content from project filesystem ./
to make it considerably easier to develop static HTML/Javascript
with D3 - when consuming REST JSON/XML services.

### D3 Test
BFrom a browser issue the following url
```
http://localhost:8080/src/main/resources/static/plotXML1.html
```
