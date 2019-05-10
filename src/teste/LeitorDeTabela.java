package teste;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.text.PDFTextStripper;

public class LeitorDeTabela {
	private PDDocument documentoPDF;
	private PDPage pagina;
	private PDPageContentStream streamDeConteudo;
	private PDFTextStripper pdfStripper;
	private PDFTextStripperCustom pdfStripperCustom;
	
	public LeitorDeTabela(String caminhoArquivo) {
		try {
			this.documentoPDF = PDDocument.load(new File(caminhoArquivo));
			System.out.println("Documento carregado");
			this.pagina = this.documentoPDF.getPage(1);
			//this.streamDeConteudo = new PDPageContentStream(this.documentoPDF, this.pagina);
			this.pdfStripper = new PDFTextStripper();
			this.pdfStripperCustom = new PDFTextStripperCustom();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String obterTexto(PDFTextStripper stripper) {
		String resultado = null;
		try {
			resultado = stripper.getText(documentoPDF);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	/**
	 * @return the documentoPDF
	 */
	public PDDocument getDocumentoPDF() {
		return documentoPDF;
	}

	/**
	 * @return the pdfStripper
	 */
	public PDFTextStripper getPdfStripper() {
		return pdfStripper;
	}
	
	/**
	 * @return the pdfStripperCustom
	 */
	public PDFTextStripperCustom getPdfStripperCustom() {
		return pdfStripperCustom;
	}

	/**
	 * @return the pagina
	 */
	public PDPage getPagina() {
		return pagina;
	}

	/**
	 * @return the streamDeConteudo
	 */
	public PDPageContentStream getStreamDeConteudo() {
		return streamDeConteudo;
	}
	
	public void close() throws IOException {
		this.documentoPDF.close();
	}
}
