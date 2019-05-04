package br.com.rp.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.ejb.Stateless;

@Stateless
public class ProcessadorXmlService {

	public void salvar(String xml) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("d://teste.txt")));
			bw.write(xml);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
