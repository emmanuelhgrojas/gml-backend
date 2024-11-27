package com.bussiness.go.software.services.implementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.codec.binary.Base64;
import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.bussiness.go.software.services.IFuncionesGeneralesService;

@Service
public class FuncionesGeneralesServiceImpl implements IFuncionesGeneralesService{

	public Boolean eliminarArchivo(String pathArchivo) throws IOException {
		File archivo = new File(pathArchivo);
		if(archivo.exists()) {
			FileInputStream leerArchivo = new FileInputStream(archivo);
			leerArchivo.close();
			return archivo.delete();
		}
		return false;
	}
	
	public String encodeFileToBase64Binary(String nombreArchivo) {
		try {
			File file = new File(nombreArchivo);
			byte[] bytes = loadFile(file);
			Base64 base64 = new Base64();
			byte[] encoded = base64.encode(bytes);
			String encodedString = new String(encoded);
			return encodedString;
		} catch (IOException ex) {
			System.out.println("IOException: "+ex);
			return null;
		}
	}
	
	@SuppressWarnings("resource")
	private byte[] loadFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);

		long length = file.length();
		if (length > Integer.MAX_VALUE) {
			// File is too large
		}
		byte[] bytes = new byte[(int) length];

		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}

		if (offset < bytes.length) {
			throw new IOException("Could not completely read file " + file.getName());
		}

		is.close();
		return bytes;
	}
}
