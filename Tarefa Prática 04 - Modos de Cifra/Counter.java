/*
 * Seguranca Computacional 2019.1 - Prof. Dr. Valerio Rosset
 * Pratica 04 - Modos de Cifra
 * Nome: Flavia Yumi Ichikura RA: 111791
 * Nome: Willian Dihanster Gomes de Oliveira RA: 112269	
*/

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Counter {
    
    /*Funcao para cifrar/decifrar uma imagem*/
    public static void cifraImagem (String nomeArquivo, int key1, SDES SDES) throws IOException {
    	int r, g, b, w, h, color, cont, key;
    	int [] pixels;
    	int matrixRGB[][];
    	BufferedImage original = ImageIO.read(new File(nomeArquivo));

    	BufferedImage imagem = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
    	imagem.getGraphics().drawImage(original, 0, 0, null);
    	for(int y = 0; y < original.getHeight(); y++){
    		for(int x = 0; x < original.getWidth(); x++){
    			imagem.setRGB(x, y, original.getRGB(x,y));
    		}
    	}

    	w = imagem.getWidth();
    	h = imagem.getHeight();
    	pixels = imagem.getRGB(0, 0, w, h, null, 0, w);
    	matrixRGB = new int[w*h][3];
    	key = key1;

    	for (int col = 0; col < w; col++) {
    		for (int lin = 0; lin < h; lin++) {
    			color =  pixels[w * lin + col];
    			r = (color & 0xff0000) / 65536;
    			g = (color & 0xff00) / 256;
    			b = (color & 0xff);
    			matrixRGB[w * lin + col][0] = r; 
    			matrixRGB[w * lin + col][1] = g; 
    			matrixRGB[w * lin + col][2] = b;
    		}
    	}

        cont = 0;
        for (Integer col = 0; col < w; col++) {
    		for (int lin = 0; lin < h; lin++) {
                    //if (cont > 256)
                      //  cont = 0;
                    int n = SDES.cifrar(cont, key);
                    Integer [] result = SDES.xor(SDES.intToBinary(matrixRGB[w * lin + col][0]), SDES.intToBinary(n));
                    matrixRGB[w * lin + col][0] = SDES.binaryToInt(result);
                    
                    result = SDES.xor(SDES.intToBinary(matrixRGB[w * lin + col][1]), SDES.intToBinary(n));
                    matrixRGB[w * lin + col][1] = SDES.binaryToInt(result);
                    
                    result = SDES.xor(SDES.intToBinary(matrixRGB[w * lin + col][2]), SDES.intToBinary(n));
                    matrixRGB[w * lin + col][2] = SDES.binaryToInt(result);
                    
                    r = matrixRGB[w * lin + col][0]; 
                    g = matrixRGB[w * lin + col][1]; 
                    b = matrixRGB[w * lin + col][2]; 
                    color = (r * 65536) + (g * 256) + b;
                    pixels[w * lin + col] = color;
                    
                    cont++;
                }
        }
        
    	imagem.setRGB(0, 0, w, h, pixels, 0, w);
    	ImageIO.write((RenderedImage) imagem, "BMP", new File(nomeArquivo.substring(0, nomeArquivo.lastIndexOf("\\")).concat("\\saida.bmp")));
        
        JOptionPane.showMessageDialog(null,"Operação com Counter concluida! :D");

    }
    
    /*Chama a funcao de leitura da imagem para cifra-la*/
    public int cifrar (String entrada, int key, SDES cipher) throws IOException {
        cifraImagem(entrada, key, cipher);
        return 1;
    }

    /*Chama a funcao de leitura da imagem para decifra-la*/
    public int decifrar (String entrada, int key, SDES cipher) throws IOException {
        cifraImagem(entrada, key, cipher);
        return 1;    
    }

}
