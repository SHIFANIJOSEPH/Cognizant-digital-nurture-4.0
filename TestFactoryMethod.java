package com.cognizant;

interface Document{
  void create();
}

class WordDocument implements Document{

	@Override
	public void create() {
		
		System.out.println("Word Document is creating...");
	}
	
}
class PdfDocument implements Document{

	@Override
	public void create() {
		System.out.println("Pdf Document is creating...");
	}
	
}
class ExcelDocument implements Document{

	@Override
	public void create() {
		System.out.println("Excel Document is creating...");
		
	}
	
}

abstract class DocumentFactory{
	
	public abstract Document createDocument();
	
}
class WordDocumentFactory extends DocumentFactory{

	@Override
	public Document createDocument() {
		return new WordDocument();
	}
	
}
class PdfDocumentFactory extends DocumentFactory{

	@Override
	public Document createDocument() {
		return new PdfDocument();
	}
	
}

class ExcelDocumentFactory extends DocumentFactory{

	@Override
	public Document createDocument() {
		return new ExcelDocument();
	}
	
}



public class TestFactoryMethod {
	
	public static void main(String [] args) {
		//word
		DocumentFactory word = new WordDocumentFactory();
		Document doc1 = word.createDocument();
		doc1.create();
		
		//pdf
		
		DocumentFactory pdf = new PdfDocumentFactory();
		Document doc2 = pdf.createDocument();
		doc2.create();
		
		//excel
		
		DocumentFactory excel = new ExcelDocumentFactory();
		Document doc3 = excel.createDocument();
		doc3.create();
}
}