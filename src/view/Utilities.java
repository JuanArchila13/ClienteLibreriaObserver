package view;

import java.awt.Color;

public interface Utilities {
	public final static Color MAINCOLOR = new Color(46,55,100);
    public final static Color WHITECOLOR = new Color(235,236,240);
    public final static Color STRONGBLACK = new Color(14,29,38);
    public final static Color STRONGGRAY = new Color(38,38,38);
    public final static Color GRAY = new Color(89,89,89);
    public final static Color LIGHTGRAY = new Color(166,166,166);
    public final static Color BEIGE = new Color(242,242,199);
    public final static Color HOVERCOLOR = new Color(74,87,120);
	public final static String USER_ICON_PATH = "data\\icons\\iconUser.png";
	public final static String PASSWORD_ICON_PATH = "data\\icons\\iconPassword.png";
    public final static String USER_CREATED = "Se ha creado el usuario";
	public final static String ADMIN_CREATED = "Se ha creado el administrador";
	public final static String ADMIN_NO_REGISTER = "El administrador no se encuentra registrado";
	public final static String USER_NO_REGISTER = "El usuario no se encuentra registrado";
	public final static String USER_IS_CREATED = "El usuario ya esta creado";
	public final static String ADMIN_IS_CREATED = "El administrador ya esta creado";
	public final static String SESSION_IS_ACTIVE = "Ya se encuetra la sesion activa para el usuario";
	public final static String BOOK_IS_CREATED = "El libro ya esta creado";
	public final static String BOOK_CREATED_SUCCESFULLY = "El libro fue creado exitosamente.";
	public final static String BOOK_REMOVE_SUCCESFULLY = "El libro ha sido eliminado exitosamente.";
	public final static String QUANTITY_ADDED_SUCCESFULLY = "La cantidad de libros fue modificada.";
	public final static String BOOK_GIVE_BACK_SUCCEFULLY = "El libro fue devuelto exitosamente";
	public final static String BOOK_RENTED_SUCCEFULLY= "El libro fue agregado a su lista de libros rentados.";
}
