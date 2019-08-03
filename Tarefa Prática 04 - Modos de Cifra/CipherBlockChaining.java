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

public class CipherBlockChaining {

    /*Funcao para cifrar uma imagem*/
    public static void cifraImagem(Integer[][] matrixRGB, int key,
            SDES SDES, Integer[] ivr, Integer[] ivg, Integer[] ivb) {
        for (int i = 0; i < matrixRGB.length; i++) {
            Integer pixelAtual[] = SDES.intToBinary(matrixRGB[i][0]);
            Integer result[] = SDES.xor(pixelAtual, ivr);
            Integer novo = SDES.binaryToInt(result);
            matrixRGB[i][0] = SDES.cifrar(novo, key) * 65536;
            ivr = SDES.intToBinary(matrixRGB[i][0] / 65536);

            pixelAtual = SDES.intToBinary(matrixRGB[i][1]);
            result = SDES.xor(pixelAtual, ivg);
            novo = SDES.binaryToInt(result);
            matrixRGB[i][1] = SDES.cifrar(novo, key) * 256;
            ivg = SDES.intToBinary(matrixRGB[i][1] / 256);

            pixelAtual = SDES.intToBinary(matrixRGB[i][2]);
            result = SDES.xor(pixelAtual, ivb);
            novo = SDES.binaryToInt(result);
            matrixRGB[i][2] = SDES.cifrar(novo, key);
            ivb = SDES.intToBinary(matrixRGB[i][2]);

        }
    }

    /*Funcao para decifrar uma imagem*/
    public static void decifraImagem(Integer[][] matrixRGB, int key,
            SDES SDES, Integer[] ivr, Integer[] ivg, Integer[] ivb) {
        for (int i = 0; i < matrixRGB.length; i++) {
            Integer n = SDES.decifrar(matrixRGB[i][0], key);
            Integer pixelAtual[] = SDES.intToBinary(n);
            Integer novo[] = SDES.xor(pixelAtual, ivr);
            ivr = SDES.intToBinary(matrixRGB[i][0]);
            matrixRGB[i][0] = (SDES.binaryToInt(novo)) * 65536;

            n = SDES.decifrar(matrixRGB[i][1], key);
            pixelAtual = SDES.intToBinary(n);
            novo = SDES.xor(pixelAtual, ivg);
            ivg = SDES.intToBinary(matrixRGB[i][1]);
            matrixRGB[i][1] = (SDES.binaryToInt(novo)) * 256;

            n = SDES.decifrar(matrixRGB[i][2], key);
            pixelAtual = SDES.intToBinary(n);
            novo = SDES.xor(pixelAtual, ivb);
            ivb = SDES.intToBinary(matrixRGB[i][2]);
            matrixRGB[i][2] = (SDES.binaryToInt(novo));

        }
    }

    /*Funcao que prepara a imagem para ser cifrada/decifrada*/
    public static void preparaImagem(String nomeArquivo, int key1, int type, SDES cipher, Integer[] iv) throws IOException {
        int r, g, b, w, h, color, key;
        int[] pixels;
        Integer matrixRGB[][];
        BufferedImage original = ImageIO.read(new File(nomeArquivo));

        BufferedImage imagem = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        imagem.getGraphics().drawImage(original, 0, 0, null);
        for (int y = 0; y < original.getHeight(); y++) {
            for (int x = 0; x < original.getWidth(); x++) {
                imagem.setRGB(x, y, original.getRGB(x, y));
            }
        }

        w = imagem.getWidth();
        h = imagem.getHeight();
        pixels = imagem.getRGB(0, 0, w, h, null, 0, w);
        matrixRGB = new Integer[w * h][3];
        key = key1;

        for (int col = 0; col < w; col++) {
            for (int lin = 0; lin < h; lin++) {
                color = pixels[w * lin + col];
                r = (color & 0xff0000) / 65536;
                g = (color & 0xff00) / 256;
                b = (color & 0xff);
                matrixRGB[w * lin + col][0] = r;
                matrixRGB[w * lin + col][1] = g;
                matrixRGB[w * lin + col][2] = b;
            }
        }

        Integer ivr[] = iv.clone();
        Integer ivg[] = iv.clone();
        Integer ivb[] = iv.clone();

        if (type == 1) {
            cifraImagem(matrixRGB, key, cipher, ivr, ivg, ivb);
        } else if (type == 2) {
            decifraImagem(matrixRGB, key, cipher, ivr, ivg, ivb);
        }

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
        ImageIO.write((RenderedImage) imagem, "BMP", new File(nomeArquivo.substring(0, nomeArquivo.lastIndexOf("\\")).concat("\\saida.bmp")));

        JOptionPane.showMessageDialog(null,"Operação com CBC concluida! :D");

    }

    /*Chama a funcao de prepara a imagem no modo de cifragem*/
    public int cifrar(String entrada, int key, SDES cipher, Integer[] iv) throws IOException {
        preparaImagem(entrada, key, 1, cipher, iv);
        return 1;
    }
    
    /*Chama a funcao de prepara a imagem no modo de decifragem*/
    public int decifrar(String entrada, int key, SDES cipher, Integer[] iv) throws IOException {
        preparaImagem(entrada, key, 2, cipher, iv);
        return 1;
    }

}
