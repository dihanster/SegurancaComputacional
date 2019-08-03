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

public class EletronicCodeBlockBook {
    
    /*Funcao para cifrar uma imagem*/
    public static void cifraImagem (int [][] matrixRGB, int key) {
    	for (int i = 0; i < matrixRGB.length; i++) {
    		matrixRGB[i][0] = SDES.cifrar(matrixRGB[i][0], key) * 65536;
    		matrixRGB[i][1] = SDES.cifrar(matrixRGB[i][1], key) * 256;
    		matrixRGB[i][2] = SDES.cifrar(matrixRGB[i][2], key);
    	}
    }
    
    /*Funcao para decifrar uma imagem*/
    public static void decifraImagem (int [][] matrixRGB, int key) {
    	for (int i = 0; i < matrixRGB.length; i++) {
    		matrixRGB[i][0] = SDES.decifrar(matrixRGB[i][0], key) * 65536;
    		matrixRGB[i][1] = SDES.decifrar(matrixRGB[i][1], key) * 256;
    		matrixRGB[i][2] = SDES.decifrar(matrixRGB[i][2], key);
    	}
    }
    
    /*Funcao que prepara a imagem para ser cifrada/decifrada*/
    public static void preparaImagem (String nomeArquivo, int key1, int tipo, SDES SDES) throws IOException {
    	int r, g, b, w, h, color, key;
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

        if (tipo == 1)
            cifraImagem(matrixRGB, key);
        else
            decifraImagem(matrixRGB, key);
       
        for (int col = 0; col < w; col++) {
            for (int lin = 0; lin < h; lin++) {
                r = matrixRGB[w * lin + col][0]; 
    		g = matrixRGB[w * lin + col][1]; 
    		b = matrixRGB[w * lin + col][2]; 
  		color = r + g + b;
                pixels[w * lin + col] = color;
            }
    	}

    	imagem.setRGB(0, 0, w, h, pixels, 0, w);
        String nomeSaida = nomeArquivo.substring(0, nomeArquivo.lastIndexOf("\\")).concat("\\saida.bmp");
        System.out.println(nomeSaida);
    	ImageIO.write((RenderedImage) imagem, "PNG", new File(nomeSaida));

        JOptionPane.showMessageDialog(null,"Operação com ECB concluida! :D");

    }

    /*Chama a funcao de prepara a imagem no modo de cifragem*/
    public int cifrar (String entrada, int key, SDES cipher) throws IOException {
        preparaImagem(entrada, key, 1, cipher);
        return 1;
    }
    
    /*Chamam a funcao de prepara a imagem no modo de decifragem*/
    public int decifrar (String entrada, int key, SDES cipher) throws IOException {
        preparaImagem(entrada, key, 2, cipher);
        return 1;
    }
        
}

