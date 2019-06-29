package cn.it.cast.utils;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
   private static int WIDTH=125;
   private static int HEIGHT=40;
   
   
    public CheckCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	//��ȡHttpSession����
		response.setContentType("image/jpeg");	//���ñ���
		ServletOutputStream sos =response.getOutputStream();	//��ȡ�����
		//�����������Ҫ�����ͼƬ
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expiress", 0);
		//�����ڴ�ͼ�񲢻����ͼ��������
		BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();
		char [] rands = generateCheckCode();//�����������֤��
		drawBackground(g);
		drawRands(g,rands);
		g.dispose();//����ͼ��Ļ��ƹ��̣����ͼ��
		//��ͼ��������ͻ���
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(image,"JPEG",bos);
		byte[] buf=bos.toByteArray();
		response.setContentLength(buf.length);
		sos.write(buf);
		bos.close();
		sos.close();
		session.setAttribute("check_code", new String(rands)); //����֤����뵽Session��
		System.out.println("rands is "+ new String(rands));
	}

	//���û�и���Ԫ�ص���֤��ͼƬ
	private void drawRands(Graphics g, char[] rands) {
		g.setColor(Color.BLACK);
		g.setFont(new Font(null,Font.ITALIC|Font.BOLD,30));//18
		//�ڲ�ͬ�ĸ߶��������֤���ÿ���ַ�
		
		g.drawString(""+rands[0], 10, 27);
		g.drawString(""+rands[1], 35, 25);
		g.drawString(""+rands[2], 60, 28);
		g.drawString(""+rands[3], 100, 26);
		System.out.println(rands);
	}

	//����и���Ԫ�ص���֤��ͼƬ
	private void drawBackground(Graphics g) {
		//������
		g.setColor(new Color(0xDCDCDC));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//�������120�����ŵ�
		for(int i=0;i<120;i++) {
			int x = (int)(Math.random()*WIDTH);
			int y = (int)(Math.random()*HEIGHT);
			int red = (int)(Math.random()*255);
			int green = (int)(Math.random()*255);
			int blue = (int)(Math.random()*255);
			g.setColor(new Color(red,green,blue));
			g.drawOval(x, y, 1, 0);
		}
		
	}

	private char[] generateCheckCode() {
		
		String chars="0123456789qwertyuiopasdfghjklzxcvbnm";
		
		char[] rands = new char[4];
		for (int i=0;i<4;i++) {
			
			int rand =(int)(Math.random() *36);
			rands[i] = chars.charAt(rand);
		}
		
		return rands;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
