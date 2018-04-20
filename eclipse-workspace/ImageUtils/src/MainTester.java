
	import java.awt.Color;

	public class MainTester {

		public static void main(String[] args) {
			ImageUtils utils = new ImageUtils();
			Color [][] orig = utils.loadImage("src/LennaCV.png");
			
			utils.addImage(orig, "Original Image");
			Color [][] squarePixel = process(orig);
			utils.addImage(squarePixel,  "Squared Pixels");
			
			
			Color [][] stripe = stripes(orig);
			utils.addImage(stripe, "Stripes");
			
			Color [][] blueTint = blueTint(orig);
			utils.addImage(blueTint, "Blue Tint");	
			
			Color [][] pixelate = pixelate(orig);
			utils.addImage(pixelate, "Pixelated Stripes");
			
			Color [][] redTint = redTint(orig);
			utils.addImage(redTint, "Ghost Effect");
			utils.display();
		}
		public static Color[][] redTint(Color[][] img) {
			Color [][] tmp3 = ImageUtils.cloneArray(img);
			for (int i=0; i < tmp3.length; i+=2.9) {
				for (int j=0; j < tmp3[i].length; j+=1.1) {
						if (i < tmp3.length) {
						
						Color pixel = tmp3 [i][j];
						int r = pixel.getRed();
						int g = pixel.getGreen();
						int b = pixel.getBlue();
						int avg = (r+r+b);
						tmp3 [i][j]= new Color (avg-400);
				}
				}
			}
			return tmp3;
		}
		
		public static Color[][] blueTint(Color[][] img) {
			Color [][] tmp3 = ImageUtils.cloneArray(img);
			for (int i=0; i < tmp3.length; i++) {
				for (int j=0; j < tmp3[i].length; j++) {
						if (i < tmp3.length ) {
						
						Color pixel = tmp3 [i][j];
						int r = pixel.getRed();
						int g = pixel.getGreen();
						int b = pixel.getBlue();
						tmp3 [i][j]= new Color (10, 10, b);
				}
				}
			}
			return tmp3;
		}

		public static Color [][] process(Color [][] img){
			Color [][] tmp = ImageUtils.cloneArray(img);
			for (int i=0; i < tmp.length; i+=10) {
				for (int j=0; j < tmp[i].length; j+=2) {
					if (i < tmp.length) {
						
						Color pixel = tmp [i][j];
						int r = pixel.getRed();
						int g = pixel.getGreen();
						int b = pixel.getBlue();
						tmp [i][j]= new Color (r,90,80);
					}
				}
			}
			return tmp;

		}
		public static Color [][] stripes (Color [][] img){
			Color [][] tmp2 = ImageUtils.cloneArray(img);
			for (int i=0; i < tmp2.length; i+=1) {
				for (int j=0; j < tmp2[i].length; j+=1) {
					if (i < tmp2.length*0.2 ) {
						
						Color pixel = tmp2 [i][j];
						int r = pixel.getRed();
						int g = pixel.getGreen();
						int b = pixel.getBlue();
						tmp2 [i][j]= new Color (r, g, b);
					}
					else if (i> tmp2.length*0.2 && i< tmp2.length*0.4 ) {
						Color pixel = tmp2 [i][j];
						int r = pixel.getRed();
						int g = pixel.getGreen();
						int b = pixel.getBlue();
						tmp2 [i][j]= new Color (r,210,0);
					}
					else if(i> tmp2.length*0.4 && i< tmp2.length*0.6) {
						Color pixel = tmp2 [i][j];
						int r = pixel.getRed();
						int g = pixel.getGreen();
						int b = pixel.getBlue();
						tmp2 [i][j]= new Color (r,0,0);
						}
					else if (i> tmp2.length*0.6 && i< tmp2.length*0.8) {
						Color pixel = tmp2 [i][j];
						int r = pixel.getRed();
						int g = pixel.getGreen();
						int b = pixel.getBlue();
						tmp2 [i][j]= new Color (0,g,b);
					}
					else if (i> tmp2.length*0.8 && i< tmp2.length) {
						Color pixel = tmp2 [i][j];
						int r = pixel.getRed();
						int g = pixel.getGreen();
						int b = pixel.getBlue();
						tmp2 [i][j]= new Color (245,g,250);
					}
					
				}
			}
			return tmp2;
			
		}
		public static Color [][] pixelate (Color [][] img){
			Color [][] tmp2 = ImageUtils.cloneArray(img);
			for (int i=0; i < tmp2.length; i+=2) {
				for (int j=0; j < tmp2[i].length; j+=2) {
					if (i < tmp2.length*0.2 ) {
						
						Color pixel = tmp2 [i][j];
						int r = pixel.getRed();
						int g = pixel.getGreen();
						int b = pixel.getBlue();
						tmp2 [i][j]= new Color (r, g, b);
					}
					else if (i> tmp2.length*0.2 && i< tmp2.length*0.4 ) {
						Color pixel = tmp2 [i][j];
						int r = pixel.getRed();
						int g = pixel.getGreen();
						int b = pixel.getBlue();
						tmp2 [i][j]= new Color (r,210,0);
					}
					else if(i> tmp2.length*0.4 && i< tmp2.length*0.6) {
						Color pixel = tmp2 [i][j];
						int r = pixel.getRed();
						int g = pixel.getGreen();
						int b = pixel.getBlue();
						tmp2 [i][j]= new Color (r,0,0);
						}
					else if (i> tmp2.length*0.6 && i< tmp2.length*0.8) {
						Color pixel = tmp2 [i][j];
						int r = pixel.getRed();
						int g = pixel.getGreen();
						int b = pixel.getBlue();
						tmp2 [i][j]= new Color (0,g,b);
					}
					else if (i> tmp2.length*0.8 && i< tmp2.length) {
						Color pixel = tmp2 [i][j];
						int r = pixel.getRed();
						int g = pixel.getGreen();
						int b = pixel.getBlue();
						tmp2 [i][j]= new Color (245,g,250);
					}
					
				}
			}
			return tmp2;
			
		}
	}


