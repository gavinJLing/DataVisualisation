package co.uk.lingzone.datasource.perlin.service;

import co.uk.lingzone.datasource.perlin.dto.Data3D;
import co.uk.lingzone.datasource.perlin.generator.ImprovedNoise;


public class Data3DService {

    Data3D purlinData;
    
    public Data3D generate3dnoise(double xOffset, double xStep,int xCount , 
                                  double yOffset, double yStep,int yCount ,
                                  double zOffset, double zStep,int zCount) {
        
        purlinData = new Data3D();
                
        purlinData.getHeader().setFormat("PERLIN");
        purlinData.getHeader().setxOffset(xOffset);
        purlinData.getHeader().setxCount(xCount);
        purlinData.getHeader().setxStep(xStep);
        
        purlinData.getHeader().setyOffset(yOffset);
        purlinData.getHeader().setyCount(yCount);
        purlinData.getHeader().setyStep(yStep);
        
        purlinData.getHeader().setzOffset(zOffset);
        purlinData.getHeader().setzCount(zCount);
        purlinData.getHeader().setzStep(zStep);
        
        double xpnMax = xOffset + (xStep * xCount);
        double ypnMax = yOffset + (yStep * yCount);
        double zpnMax = zOffset + (zStep * zCount);
        
        for (double xpn = xOffset; xpn <xpnMax; xpn+= xStep) {
            for (double ypn = yOffset; ypn <  ypnMax; ypn+= yStep) {
                for (double zpn = zOffset; zpn < zpnMax; zpn+= zStep) {
                    // use GItHub Perlin noise generator alg. (Ken Perlin (c) 2002)
                    
                    double noise = ImprovedNoise.noise(xpn, ypn , zpn); 
                    
                    purlinData.add(xpn, ypn, zpn , noise);
                    
                    System.out.println("Gen: x:"+xpn + ", y:"+ypn + " ,z:"+zpn + " give value p:" + noise);
                }
            }
        
        }
        return purlinData;
    }
    
    
   
}
