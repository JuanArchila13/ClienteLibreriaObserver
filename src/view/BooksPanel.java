package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import structure.Book;

public class BooksPanel extends JPanel {
	private ArrayList<Item> items;
	public BooksPanel(ActionListener listener,MouseListener mouseListener,ArrayList<Book> bookSet) {
		setSize(855, 440);
		setBackground(MainWindow.WHITECOLOR);
		items = new ArrayList<Item>();
		GridLayout layout = new GridLayout();//Layout tipo Grid con estructura de matriz
		layout.setColumns(3);
		layout.setHgap(13);//Establece la separacion entre columnas
		layout.setVgap(13);//Establece la separacion entre filas;
		filBooksPanel(layout,listener,mouseListener,bookSet);
		setLayout(layout);
	}

	private void filBooksPanel(GridLayout layout,ActionListener listener,MouseListener mouseListener,ArrayList<Book> bookSet) {
		int count= 0; //Se encarga de controlar el numero de elementos por fila
		for(int i = 0;i<bookSet.size();i++) {//Numero de items a crear
			if(count == layout.getColumns()) {
				layout.setRows(layout.getRows()+1);
				count = 0;
			}
			Book book = bookSet.get(i);
			Item item = new Item(listener,mouseListener,book);
items.add(item);
			add(item);
			count++;
		}
	}
	

}
