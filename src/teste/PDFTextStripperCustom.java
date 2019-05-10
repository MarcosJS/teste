package teste;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

public class PDFTextStripperCustom extends PDFTextStripper{
	private ArrayList<PalavraPdf> dados = new ArrayList<PalavraPdf>();
	public PDFTextStripperCustom() throws IOException {

	}

	/**
	 * Override the default functionality of PDFTextStripper.
	 */

	@Override
	protected void writeString(String string, List<TextPosition> textPositions) throws IOException {
		String textoCompleto = "";
		String palavra = "";
		PalavraPdf palavraPdf = new PalavraPdf();
		List<TextPosition> text = textPositions;
		
		for(int i = 0; i < text.size(); i++) {
			if(!(text.get(i).getUnicode().equals(" "))) {
				palavraPdf.adicionar(text.get(i).getUnicode(), text.get(i).getXDirAdj(), text.get(i).getYDirAdj());
				palavra += text.get(i).getUnicode();
			} 
			if(text.get(i).getUnicode().equals(" ")) {
				if(palavraPdf.tamanho() > 0 ) {
					this.dados.add(palavraPdf);
				}
				PalavraPdf espaco = new PalavraPdf();
				espaco.adicionar(text.get(i).getUnicode(), text.get(i).getXDirAdj(), text.get(i).getYDirAdj());
				this.dados.add(espaco);
				palavraPdf = new PalavraPdf();
				textoCompleto += palavra + text.get(i).getUnicode();
				palavra = "";
			}
			if(i == text.size() - 1) {
				if(palavraPdf.tamanho() > 0) {
					this.dados.add(palavraPdf);
				}
				textoCompleto += palavra;
			}
	    }
		/*PalavraPdf palav = new PalavraPdf();
		palav.adicionar(this.getLineSeparator(), 0, 0);
		this.dados.add(palav);*/
		writeString(textoCompleto);
	}

	/**
	 * @return the dados
	 */
	public ArrayList<PalavraPdf> getDados() {
		return dados;
	}
}
