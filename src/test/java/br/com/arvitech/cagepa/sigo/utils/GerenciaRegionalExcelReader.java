package br.com.arvitech.cagepa.sigo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import br.com.arvitech.cagepa.sigo.basicas.GerenciaRegional;

public class GerenciaRegionalExcelReader {

	private final String fileName = new File("").getAbsolutePath() + "/src/test/resources/gerenciasregionais.xls";
	private FileInputStream arquivo;
	private List<GerenciaRegional> listaGerRegionais = new ArrayList<GerenciaRegional>();

	public GerenciaRegionalExcelReader() throws IOException {

		try {
			this.arquivo = new FileInputStream(new File(this.fileName));

			HSSFWorkbook workbook = new HSSFWorkbook(arquivo);

			HSSFSheet sheetAlunos = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheetAlunos.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();

				GerenciaRegional gerenciaregional = new GerenciaRegional();
				this.listaGerRegionais.add(gerenciaregional);
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getColumnIndex()) {
					case 1:
						gerenciaregional.setNome(cell.getStringCellValue());
						break;
					case 2:
						gerenciaregional.setSigla(cell.getStringCellValue());
						break;
					}
				}
			}
			workbook.close();
			arquivo.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Arquivo Excel não encontrado!");
		}
	}

	public List<GerenciaRegional> getGerenciasRegionais() {

		if (listaGerRegionais.size() == 0) {
			System.out.println("Nenhum aluno encontrado!");
		} else {
			for (GerenciaRegional gerenciaregional : listaGerRegionais) {
				System.out
						.println("Gerencia : " + gerenciaregional.getNome() + " Sigla: " + gerenciaregional.getSigla());
			}
		}
		
		
		return this.listaGerRegionais;

	}
	
	public GerenciaRegional getGerenciaRegional (int indice){
		
		return this.listaGerRegionais.get(indice);
	}

}
