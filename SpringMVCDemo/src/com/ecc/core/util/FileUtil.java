package com.ecc.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * File操作封装
 * 
 * 判断,复制,移动,创建,删除
 * 
 * 
 * @author guoyl
 *
 */
public class FileUtil {
	
	
	
	/**
	 * 文件复制
	 * @param source
	 * @param target
	 * @throws IOException 
	 */
	public void copy(String source,String target) throws IOException{
		this.copy(new File(source), new File(target));
	}
	/**
	 * 文件复制
	 * @param source
	 * @param targer
	 * @throws IOException
	 */
	public void copy(File source,File targer) throws IOException{
		int length = 2097152;
        FileInputStream in = new FileInputStream(source);  
        FileOutputStream out = new FileOutputStream(targer);  
        FileChannel inC = in.getChannel();  
        FileChannel outC = out.getChannel();  
        ByteBuffer b = null;  
        while (true) {  
            if (inC.position() == inC.size()) {  
                inC.close();  
                outC.close();  
            }  
            if ((inC.size() - inC.position()) < length) {  
                length = (int) (inC.size() - inC.position());  
            } else 
                length = 2097152;  
            b = ByteBuffer.allocateDirect(length);  
            inC.read(b);  
            b.flip();  
            outC.write(b);  
            outC.force(false);  
        }  
	}
	
}
