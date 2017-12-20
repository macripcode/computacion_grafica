package org.yourorghere;

/*************************************
 * Maria Cristina Portilla Cortes    *
 * cod: 0844113 plan:3743            *
 * Proyecto Computacion Grafica      *     
 * Profesor: Simena Dinas            *
 ************************************/

//Importamos las librerias necesarias para OPENGL
import com.sun.opengl.util.Animator;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

import javax.swing.JFrame;
import com.sun.opengl.util.GLUT;
//Librerias para el uso del teclado
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Biblioteca extends JFrame implements KeyListener {

    //Variables para funciones de OPENGL
    static GL gl;
    static GLU glu;
    static GLUT glut;
    static GLCanvas canvas;

    //Variables para la rotaci�n
    private static float rotarX = 0;
    private static float rotarY = 0;
    private static float rotarZ = 0;
    //Variables para la traslacion
    private static float trasladaX = 0;
    private static float trasladaY = 0;
    private static float trasladaZ = 0;

    //Constructor de la clase
    public Biblioteca() {
        //Propiedades para el frame
        setSize(700, 600);
        setLocationRelativeTo(null);
        setTitle("Biblioteca Mario Carvajal");
        setResizable(false);
        //invocamos a la clase Graphic
        GraphicListener listener = new GraphicListener();
        //Se instancia al canvas y variables
        canvas = new GLCanvas();
        gl = canvas.getGL();
        glu = new GLU();
        glut = new GLUT();

        //Se anade el oyente que renderiza los graficos de el metodo
        //display
        canvas.addGLEventListener(listener);
        getContentPane().add(canvas);

        //Animaciones
        Animator animator = new Animator(canvas);
        animator.start();

        //Anadimos la interfaz keylistener
        addKeyListener(this);
    }

    //Main principal de la clase
    public static void main(String args[]) {
        Biblioteca frame = new Biblioteca();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //Creacion de la clase GraphicListener
    public class GraphicListener implements GLEventListener {

        public void display(GLAutoDrawable arg0) {
            //inicializamos las variables OPENGl
            gl = arg0.getGL();
            //limpiamos el buffer
            gl.glClear(gl.GL_COLOR_BUFFER_BIT);
            //Establecemos el color de fondo de la ventana de colores RGB
            gl.glColor3f(.92f, .625f, .12f); 
            gl.glPushMatrix();
            gl.glMatrixMode(gl.GL_PROJECTION);
            gl.glLoadIdentity();

            //Establecer una perspectiva
            glu.gluPerspective(50, 2, 0, 30);
            //Variables de movimiento para la camara
            gl.glRotatef(rotarX, 1, 0, 0);
            gl.glRotatef(rotarY, 0, 1, 0);
            //Establecemos la camara
            glu.gluLookAt(0.5 + trasladaX, .5 + trasladaY, 5.5 + trasladaZ,0.5+trasladaX, 0,2.5+trasladaZ,0.0, 1.0, 0.0);
            gl.glLineWidth(5);
            
            //entrada para biblioteca
           
           //camino
            gl.glBegin(gl.GL_QUADS);
            gl.glEnable(gl.GL_BLEND);
            gl.glColor3f(0.5f,0.5f,0.5f);
             gl.glVertex3f(0, 0, 40);
             gl.glVertex3f(60,0,40); 
             gl.glVertex3f(60,0,50);
             gl.glVertex3f(0,0,50);
            gl.glEnd();
            
            //creando trama camino
            
             gl.glBegin(gl.GL_LINES);
              gl.glColor3f(0,0,0); 
              for(int i=0;i<25;i++)
              {
                  gl.glVertex3f((i*4),0,40);
                  gl.glVertex3f((i*4),0,50);
              }
              
              for(int i=40;i<50;i++)
              {
                  gl.glVertex3f(0,0,i);
                  gl.glVertex3f(50,0,i);
              }                                   
           gl.glEnd(); 
            
             
           //creando biblioteca
           //1 
           //base 
            gl.glBegin(gl.GL_QUADS); 
           gl.glColor3f(0.2f,0.2f,0.2f); 
             gl.glVertex3f(50,0,25);
             gl.glVertex3f(70,0,25);
             gl.glVertex3f(70,0,60);
             gl.glVertex3f(50,0,60);
           gl.glEnd();         
          
           //cara a
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.2f,0.2f,0.2f); 
             gl.glVertex3f(50,0,25);
             gl.glVertex3f(50,0.5f,25);
             gl.glVertex3f(70,0.5f,25);
             gl.glVertex3f(70,0,25);
           gl.glEnd();
           //cara b
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.2f,0.2f,0.2f); 
             gl.glVertex3f(70,0,25);
             gl.glVertex3f(70,0.5f,25);
             gl.glVertex3f(70,0.5f,60);
             gl.glVertex3f(70,0,60);
           gl.glEnd();
           //cara c
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.2f,0.2f,0.2f); 
             gl.glVertex3f(70,0,60);
             gl.glVertex3f(70,0.5f,60);
             gl.glVertex3f(50,0.5f,60);
              gl.glVertex3f(50,0,60);             
           gl.glEnd();
           //cara d
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.2f,0.2f,0.2f); 
             gl.glVertex3f(70,0,60);
             gl.glVertex3f(70,0.5f,60);
             gl.glVertex3f(50,0.5f,25);
              gl.glVertex3f(50,0,25);             
           gl.glEnd();
           //tapa
           gl.glBegin(gl.GL_QUADS);
           gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(50,0.5f,25);
             gl.glVertex3f(70,0.5f,25);
             gl.glVertex3f(70,0.5f,60);
             gl.glVertex3f(50,0.5f,60);
           gl.glEnd();
           
           
           //columnas traseras
          
           
            for(int i=25;i<60;i++)
           {
                gl.glBegin(gl.GL_QUADS);
              gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(68,0,i);
             gl.glVertex3f(70,0,i);
             i=i+2;
             gl.glVertex3f(70,0,i);
             gl.glVertex3f(68,0,i);
           gl.glEnd();
           i++;
               
           }
           
           for(int i=25;i<60;i++)
           {
                gl.glBegin(gl.GL_QUADS);
              gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(68,0,i);
             gl.glVertex3f(68,20,i);
             i=i+2;
             
             gl.glVertex3f(68,20,i);
             gl.glVertex3f(68,0,i);
           gl.glEnd();
           i++;
               
           }
           
            for(int i=25;i<60;i++)
           {
                gl.glBegin(gl.GL_QUADS);
             gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(70,0,i);
             gl.glVertex3f(70,20,i);
             i=i+2;
             
             gl.glVertex3f(70,20,i);
             gl.glVertex3f(70,0,i);
           gl.glEnd();
           i++;
               
           }
            
           for(int i=25;i<60;i++)
           {
                gl.glBegin(gl.GL_QUADS);
             gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(68,0,i);
             gl.glVertex3f(68,20,i);
             gl.glVertex3f(70,20,i);
             gl.glVertex3f(70,0,i);
           gl.glEnd();
           i++;
               
           } 
           
           //crendo muros traseros
           
            gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.5f,0.5f,0.5f);  
             gl.glVertex3f(64,0,27);
             gl.glVertex3f(64,10,27);
             gl.glVertex3f(64,10,57);
             gl.glVertex3f(64,0,57);
           gl.glEnd();
           //muro pequenito
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.8f,0.8f,0.8f);  
             gl.glVertex3f(64,1,28);
             gl.glVertex3f(64,5,28);
             gl.glVertex3f(64,5,56);
             gl.glVertex3f(64,1,56);
           gl.glEnd();
         
           
           //finalizando muros traseros
           
             //levantando un muro 1 frontal
           //muro grande
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.5f,0.5f,0.5f);  
             gl.glVertex3f(53,0,27);
             gl.glVertex3f(53,10,27);
             gl.glVertex3f(53,10,33);
             gl.glVertex3f(53,0,33);
           gl.glEnd();
           //muro pequenito
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.8f,0.8f,0.8f);  
             gl.glVertex3f(53,1,28);
             gl.glVertex3f(53,5,28);
             gl.glVertex3f(53,5,32);
             gl.glVertex3f(53,1,32);
           gl.glEnd();
           //cristal
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0,0.5f,0.8f);
             gl.glVertex3f(53,7,28);
             gl.glVertex3f(53,9,28);
             gl.glVertex3f(53,9,32);
             gl.glVertex3f(53,7,32);
           gl.glEnd(); 
           
           //muro 2
           
            gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.5f,0.5f,0.5f);  
             gl.glVertex3f(53,0,33);
             gl.glVertex3f(53,10,33);
             gl.glVertex3f(53,10,39);
             gl.glVertex3f(53,0,39);
           gl.glEnd();
           //muro pequenito
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.8f,0.8f,0.8f);  
             gl.glVertex3f(53,1,34);
             gl.glVertex3f(53,5,34);
             gl.glVertex3f(53,5,38);
             gl.glVertex3f(53,1,38);
           gl.glEnd();
           //cristal
           gl.glBegin(gl.GL_QUADS);
           gl.glColor3f(0,0.5f,0.8f);
             gl.glVertex3f(53,7,34);
             gl.glVertex3f(53,9,34);
             gl.glVertex3f(53,9,38);
             gl.glVertex3f(53,7,38);
           gl.glEnd();
           
           //muro 3
           
            gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.5f,0.5f,0.5f);  
             gl.glVertex3f(53,0,39);
             gl.glVertex3f(53,10,39);
             gl.glVertex3f(53,10,45);
             gl.glVertex3f(53,0,45);
           gl.glEnd();
           //puerta
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0,0.5f,0.8f);  
             gl.glVertex3f(53,0,40);
             gl.glVertex3f(53,5,40);
             gl.glVertex3f(53,5,44);
             gl.glVertex3f(53,0,44);
           gl.glEnd();
           
           //lineas separatorias
           
            gl.glBegin(GL.GL_LINES);
             gl.glColor3f(0,0,0);  
             gl.glVertex3f(53,0,40);
             gl.glVertex3f(53,5,40);
             
             gl.glVertex3f(53,5,40);
             gl.glVertex3f(53,5,44);
             
             gl.glVertex3f(53,0,42);
             gl.glVertex3f(53,5,42);
             
             gl.glVertex3f(53,5,44);
             gl.glVertex3f(53,0,44);
            
            gl.glEnd();
                    
           
          //cristal 
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0,0.5f,0.8f);
             gl.glVertex3f(53,7,34);
             gl.glVertex3f(53,9,34);
             gl.glVertex3f(53,9,38);
             gl.glVertex3f(53,7,38);
           gl.glEnd();
           //muro 4
             gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.5f,0.5f,0.5f);  
             gl.glVertex3f(53,0,45);
             gl.glVertex3f(53,10,45);
             gl.glVertex3f(53,10,51);
             gl.glVertex3f(53,0,51);
           gl.glEnd();
           //muro pequenito
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.8f,0.8f,0.8f);  
             gl.glVertex3f(53,1,46);
             gl.glVertex3f(53,5,46);
             gl.glVertex3f(53,5,50);
             gl.glVertex3f(53,1,50);
           gl.glEnd();
           //cristal
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0,0.5f,0.8f);
             gl.glVertex3f(53,7,46);
             gl.glVertex3f(53,9,46);
             gl.glVertex3f(53,9,50);
             gl.glVertex3f(53,7,50);
           gl.glEnd(); 
           
           //muro 5
           
            gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.5f,0.5f,0.5f);  
             gl.glVertex3f(53,0,51);
             gl.glVertex3f(53,10,51);
             gl.glVertex3f(53,10,57);
             gl.glVertex3f(53,0,57);
           gl.glEnd();
           //muro pequenito
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.8f,0.8f,0.8f);  
             gl.glVertex3f(53,1,52);
             gl.glVertex3f(53,5,52);
             gl.glVertex3f(53,5,56);
             gl.glVertex3f(53,1,56);
           gl.glEnd();
           //cristal
           gl.glBegin(gl.GL_QUADS);
           gl.glColor3f(0,0.5f,0.8f);
             gl.glVertex3f(53,7,52);
             gl.glVertex3f(53,9,52);
             gl.glVertex3f(53,9,56);
             gl.glVertex3f(53,7,56);
           gl.glEnd();
            
         //finalizacion de muros frontales 
           
           //segundo piso biblio
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.5f,0.5f,0.5f);
            gl.glVertex3f(53,10,27);
             gl.glVertex3f(64,10,27);
             gl.glVertex3f(64,10,57);
             gl.glVertex3f(53,10,57);
           gl.glEnd();
           
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.5f,0.5f,0.5f);
            gl.glVertex3f(53,10,27);
             gl.glVertex3f(53,20,27);
             gl.glVertex3f(64,20,57);
             gl.glVertex3f(53,10,57);
           gl.glEnd();
           
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.5f,0.5f,0.5f);
            gl.glVertex3f(64,10,27);
             gl.glVertex3f(64,20,27);
             gl.glVertex3f(64,20,57);
             gl.glVertex3f(53,10,57);
           gl.glEnd();
           
            gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.5f,0.5f,0.5f);
           
             gl.glVertex3f(53,10,57);
             gl.glVertex3f(53,20,57);
             gl.glVertex3f(64,20,57);
             gl.glVertex3f(64,10,57);
           gl.glEnd();
           
            gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.5f,0.5f,0.5f);
           
             gl.glVertex3f(53,10,27);
             gl.glVertex3f(53,20,27); 
             gl.glVertex3f(53,20,57);
             gl.glVertex3f(53,10,57);
           gl.glEnd();
           
                      
           //finalizacion segundo piso biblio
                
           //creando columnas
            //delanteras        
           for(int i=25;i<60;i++)
           {
                gl.glBegin(gl.GL_QUADS);
              gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(50,0,i);
             gl.glVertex3f(52,0,i);
             i=i+2;
             gl.glVertex3f(52,0,i);
             gl.glVertex3f(50,0,i);
           gl.glEnd();
           i++;
               
           }
           
           for(int i=25;i<60;i++)
           {
                gl.glBegin(gl.GL_QUADS);
              gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(50,0,i);
             gl.glVertex3f(50,20,i);
             i=i+2;
             
             gl.glVertex3f(50,20,i);
             gl.glVertex3f(50,0,i);
           gl.glEnd();
           i++;
               
           }
           
            for(int i=25;i<60;i++)
           {
                gl.glBegin(gl.GL_QUADS);
             gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(52,0,i);
             gl.glVertex3f(52,20,i);
             i=i+2;
             
             gl.glVertex3f(52,20,i);
             gl.glVertex3f(52,0,i);
           gl.glEnd();
           i++;
               
           } 
            
           for(int i=25;i<60;i++)
           {
                gl.glBegin(gl.GL_QUADS); 
              gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(50,0,i);
             gl.glVertex3f(50,20,i);
             gl.glVertex3f(52,20,i);
             gl.glVertex3f(52,0,i);
           gl.glEnd();
           i++;
               
           }
           
           //muros laterales
           //muro1
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.5f,0.5f,0.5f);  
             gl.glVertex3f(53,0,27);
             gl.glVertex3f(53,10,27);
             gl.glVertex3f(59,10,27);
             gl.glVertex3f(59,0,27);
           gl.glEnd();
           //muro pequenito
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.8f,0.8f,0.8f);  
             gl.glVertex3f(54,1,27);
             gl.glVertex3f(54,5,27);
             gl.glVertex3f(58,5,27);
             gl.glVertex3f(58,1,27);
           gl.glEnd();
           //cristal
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0,0.5f,0.8f);
             gl.glVertex3f(54,7,27);
             gl.glVertex3f(54,9,27);
             gl.glVertex3f(58,9,27);
             gl.glVertex3f(58,7,27);
           gl.glEnd(); 
           
           //muro 2
           
            gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.5f,0.5f,0.5f);  
             gl.glVertex3f(59,0,27);
             gl.glVertex3f(59,10,27);
             gl.glVertex3f(65,10,27);
             gl.glVertex3f(65,0,27);
           gl.glEnd();
           //muro pequenito
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.8f,0.8f,0.8f);  
             gl.glVertex3f(60,1,27);
             gl.glVertex3f(60,5,27);
             gl.glVertex3f(64,5,27);
             gl.glVertex3f(64,1,27);
           gl.glEnd();
           //cristal
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0,0.5f,0.8f);
             gl.glVertex3f(60,7,27);
             gl.glVertex3f(60,9,27);
             gl.glVertex3f(64,9,27);
             gl.glVertex3f(64,7,27);
           gl.glEnd(); 
           
          
           
           //columnas laterales 1
           
           for(int i=54;i<70;i++)
           {
                gl.glBegin(gl.GL_QUADS);
             gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(i,0,25);
             gl.glVertex3f(i,0,27);
             i=i+2;
             gl.glVertex3f(i,0,27);
             gl.glVertex3f(i,0,25);
           gl.glEnd();
           i++;
               
           }
           
           for(int i=54;i<70;i++)
           {
                gl.glBegin(gl.GL_QUADS);
             gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(i,0,25);
             gl.glVertex3f(i,20,25);
             i=i+2;
             gl.glVertex3f(i,20,25);
             gl.glVertex3f(i,0,25);
           gl.glEnd();
           i++;
               
           }
           
           for(int i=54;i<70;i++)
           {
                gl.glBegin(gl.GL_QUADS);
              gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(i,0,25);
             gl.glVertex3f(i,20,25);             
             gl.glVertex3f(i,20,27);
             gl.glVertex3f(i,0,27);
           gl.glEnd();
           i++;
               
           }
           
            for(int i=54;i<70;i++)
           {
                gl.glBegin(gl.GL_QUADS);
             gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(i,0,27);
             gl.glVertex3f(i,20,27);
             i=i+2;
             gl.glVertex3f(i,20,27);
             gl.glVertex3f(i,0,27);
           gl.glEnd();
           i++;
               
           }
           
            
             //muros laterales 2
           
             //muros laterales
           //muro1
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.5f,0.5f,0.5f);  
             gl.glVertex3f(53,0,57);
             gl.glVertex3f(53,10,57);
             gl.glVertex3f(59,10,57);
             gl.glVertex3f(59,0,57);
           gl.glEnd();
           //muro pequenito
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.8f,0.8f,0.8f);  
             gl.glVertex3f(54,1,57);
             gl.glVertex3f(54,5,57);
             gl.glVertex3f(58,5,57);
             gl.glVertex3f(58,1,57);
           gl.glEnd();
           //cristal
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0,0.5f,0.8f);
             gl.glVertex3f(54,7,57);
             gl.glVertex3f(54,9,57);
             gl.glVertex3f(58,9,57);
             gl.glVertex3f(58,7,57);
           gl.glEnd(); 
           
           //muro 2
           
            gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.5f,0.5f,0.5f);  
             gl.glVertex3f(59,0,57);
             gl.glVertex3f(59,10,57);
             gl.glVertex3f(65,10,57);
             gl.glVertex3f(65,0,57);
           gl.glEnd();
           //muro pequenito
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.8f,0.8f,0.8f);  
             gl.glVertex3f(60,1,57);
             gl.glVertex3f(60,5,57);
             gl.glVertex3f(64,5,57);
             gl.glVertex3f(64,1,57);
           gl.glEnd();
           //cristal
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0,0.5f,0.8f);
             gl.glVertex3f(60,7,57);
             gl.glVertex3f(60,9,57);
             gl.glVertex3f(64,9,57);
             gl.glVertex3f(64,7,57);
           gl.glEnd();
           
           //muros laterales finalizacion
           
           //columnas laterales 2
            
             for(int i=54;i<70;i++)
           {
                gl.glBegin(gl.GL_QUADS);
              gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(i,0,58);
             gl.glVertex3f(i,0,60);
             i=i+2;
             gl.glVertex3f(i,0,60);
             gl.glVertex3f(i,0,58);
           gl.glEnd();
           i++;
               
           }
           
           for(int i=54;i<70;i++)
           {
                gl.glBegin(gl.GL_QUADS);
              gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(i,0,58);
             gl.glVertex3f(i,20,58);
             i=i+2;
             gl.glVertex3f(i,20,58);
             gl.glVertex3f(i,0,58);
           gl.glEnd();
           i++;
               
           }
           
           for(int i=54;i<70;i++)
           {
                gl.glBegin(gl.GL_QUADS);
             gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(i,0,58);
             gl.glVertex3f(i,20,58);             
             gl.glVertex3f(i,20,60);
             gl.glVertex3f(i,0,60);
           gl.glEnd();
           i++;
               
           }
           
            for(int i=54;i<70;i++)
           {
                gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(i,0,60);
             gl.glVertex3f(i,20,60);
             i=i+2;
             gl.glVertex3f(i,20,60);
             gl.glVertex3f(i,0,60);
           gl.glEnd();
           i++;
               
           }
            
          //techo
            
             gl.glBegin(gl.GL_QUADS);            
           gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(50,20,25);
             gl.glVertex3f(70,20,25);
             gl.glVertex3f(70,20,60);
             gl.glVertex3f(50,20,60);
           gl.glEnd();
           
           //base terraza
           
           gl.glBegin(gl.GL_QUADS);            
          gl.glColor3f(0.2f,0.2f,0.2f); 
             gl.glVertex3f(55,20,35);
             gl.glVertex3f(65,20,35);
             gl.glVertex3f(65,20,50);
             gl.glVertex3f(55,20,50);
           gl.glEnd();
           
           gl.glBegin(gl.GL_QUADS);            
         gl.glColor3f(0.2f,0.2f,0.2f); 
             gl.glVertex3f(55,20,35);
             gl.glVertex3f(55,23,35);
             gl.glVertex3f(65,23,35);
             gl.glVertex3f(65,20,35);
           gl.glEnd();
           
           gl.glBegin(gl.GL_QUADS);  
          gl.glColor3f(0.2f,0.2f,0.2f); 
             gl.glVertex3f(65,20,35);
             gl.glVertex3f(65,23,35);
             gl.glVertex3f(65,23,50);
             gl.glVertex3f(65,20,50);
           gl.glEnd();
           
            gl.glBegin(gl.GL_QUADS);            
           
          gl.glColor3f(0.2f,0.2f,0.2f);
             gl.glVertex3f(55,20,35);
             gl.glVertex3f(55,23,35);
             gl.glVertex3f(65,23,35);
             gl.glVertex3f(65,20,35);
           gl.glEnd();
           
           gl.glBegin(gl.GL_QUADS);            
             gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(65,20,50);
             gl.glVertex3f(65,23,50);
             gl.glVertex3f(55,23,50);
             gl.glVertex3f(55,20,50);
           gl.glEnd();
           
           gl.glBegin(gl.GL_QUADS);            
            gl.glColor3f(0.2f,0.2f,0.2f);
             gl.glVertex3f(55,20,50);
             gl.glVertex3f(55,23,50);
             gl.glVertex3f(55,23,35);
             gl.glVertex3f(55,20,35);
           gl.glEnd();
           
           //piso terraza
          
           
           gl.glBegin(gl.GL_QUADS);            
          gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(53,23,33);
             gl.glVertex3f(67,23,33);
             gl.glVertex3f(67,23,52);
             gl.glVertex3f(53,23,52);
           gl.glEnd();
           
           gl.glBegin(gl.GL_QUADS);            
          gl.glColor3f(0.2f,0.2f,0.2f); 
             gl.glVertex3f(53,23,33);
             gl.glVertex3f(53,26,33);
             gl.glVertex3f(67,26,33);
             gl.glVertex3f(67,23,33);
           gl.glEnd();
           
           gl.glBegin(gl.GL_QUADS);  
           gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(67,20,33);
             gl.glVertex3f(67,23,33);
             gl.glVertex3f(67,23,52);
             gl.glVertex3f(67,20,52);
           gl.glEnd();
           
            gl.glBegin(gl.GL_QUADS);            
           
         gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(53,23,33);
             gl.glVertex3f(53,26,33);
             gl.glVertex3f(67,26,33);
             gl.glVertex3f(67,23,33);
           gl.glEnd();
           
           gl.glBegin(gl.GL_QUADS);            
            gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(67,23,52);
             gl.glVertex3f(67,26,52);
             gl.glVertex3f(53,26,52);
             gl.glVertex3f(53,23,52);
           gl.glEnd();
           
           gl.glBegin(gl.GL_QUADS);            
             gl.glColor3f(0.2f,0.2f,0.2f);  
             gl.glVertex3f(53,23,52);
             gl.glVertex3f(53,26,52);
             gl.glVertex3f(53,26,33);
             gl.glVertex3f(53,23,33);
           gl.glEnd();
           //finalizacion piso terraza
        //finalizando biblioteca   
            
            
           
            
            //pradoizquierdo
            
            gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0, 1, 0);
             gl.glVertex3f(0, 0, 0);
             gl.glVertex3f(0,0, 25);
             gl.glVertex3f(16,0, 25);
             gl.glVertex3f(16,0, 0);
           gl.glEnd();
            
           //camino
            gl.glBegin(gl.GL_QUADS);
            gl.glEnable(gl.GL_BLEND);
            gl.glColor3f(0.5f,0.5f,0.5f);
             gl.glVertex3f(16, 0, 0);
             gl.glVertex3f(16,0, 25); 
             gl.glVertex3f(24,0, 25);
             gl.glVertex3f(24,0, 0);
               gl.glEnd();
             
             //tramado
             
               gl.glBegin(gl.GL_LINES);
              gl.glColor3f(0,0,0); 
              
                                        
              for(int i=0;i<12;i++)
              {  
                  gl.glVertex3f(16,0,(i*2));
                  gl.glVertex3f(24,0,(i*2));                 
              }               
             
            gl.glEnd();
            
            //prado derecho no pisar!!!
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0,1,0); 
             gl.glVertex3f(24,0,0);
             gl.glVertex3f(60,0,0);
             gl.glVertex3f(60,0,40);
             gl.glVertex3f(24,0,40);
           gl.glEnd();
           
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(0,1,0); 
             gl.glVertex3f(0,0,50);
             gl.glVertex3f(60,0,50);
             gl.glVertex3f(60,0,60);
             gl.glVertex3f(0,0,60);
           gl.glEnd(); 
           
             //piso de venta de CD's
           
            gl.glBegin(gl.GL_QUADS);
             gl.glColor3f(1.0f,0.3f,0.0f); 
             gl.glVertex3f(0,0,25);
             gl.glVertex3f(24,0,25);
             gl.glVertex3f(24,0,40);
             gl.glVertex3f(0,0,40);
           gl.glEnd();
           
           //Tramado
            gl.glBegin(gl.GL_LINES);
              gl.glColor3f(0,0,0); 
              for(int i=25;i<40;i++)
              {
                  gl.glVertex3f(0,0,i);
                  gl.glVertex3f(24,0,i);
              }
              
               for(int i=0;i<24;i++)
              {
                  gl.glVertex3f(i,0,25);
                  gl.glVertex3f(i,0,40);
              }                                  
           gl.glEnd();
           
            
            //columna 1
           //desde arriba columna
            gl.glBegin(gl.GL_QUADS);
            gl.glEnable(gl.GL_BLEND);
            gl.glColor3f(1.0f,0.5f,0.0f);
            gl.glVertex3f(16, 10, 0);
            gl.glVertex3f(16,10,2); 
            gl.glVertex3f(24,10,2);
            gl.glVertex3f(24,10,0);         
            gl.glEnd();
            
            
            gl.glBegin(gl.GL_QUADS);
            gl.glEnable(gl.GL_BLEND);
             gl.glColor3f(1.0f,0.5f,0.0f);
            gl.glVertex3f(16, 0, 0);
            gl.glVertex3f(16,10,0); 
            gl.glVertex3f(16,10,2);
            gl.glVertex3f(16,0,2);         
            gl.glEnd();    
                        
            
         
            gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(1.0f,0.5f,0.0f); 
             gl.glVertex3f(24, 0, 0);
             gl.glVertex3f(24,10, 0);
             gl.glVertex3f(24,10, 2);
             gl.glVertex3f(24,0, 2);
                      
            gl.glEnd();
            
             //columna 2
           //desde arriba columna
            gl.glBegin(gl.GL_QUADS);
            gl.glEnable(gl.GL_BLEND);
            gl.glColor3f(1.0f,0.5f,0.0f);
            gl.glVertex3f(16, 10, 3);
            gl.glVertex3f(16,10,5); 
            gl.glVertex3f(24,10,5);
            gl.glVertex3f(24,10,3);         
            gl.glEnd();
            
            
            gl.glBegin(gl.GL_QUADS);
            gl.glEnable(gl.GL_BLEND);
             gl.glColor3f(1.0f,0.5f,0.0f);
            gl.glVertex3f(16, 0, 3);
            gl.glVertex3f(16,10,3); 
            gl.glVertex3f(16,10,5);
            gl.glVertex3f(16,0,5);         
            gl.glEnd();    
                        
            
         
            gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(1.0f,0.5f,0.0f); 
             gl.glVertex3f(24, 0, 3);
             gl.glVertex3f(24,10, 3);
             gl.glVertex3f(24,10, 5);
             gl.glVertex3f(24,0, 5);
                      
            gl.glEnd();
            
              //columna 2
           //desde arriba columna
            gl.glBegin(gl.GL_QUADS);
            gl.glEnable(gl.GL_BLEND);
            gl.glColor3f(1.0f,0.5f,0.0f);
            gl.glVertex3f(16, 10, 6);
            gl.glVertex3f(16,10,8); 
            gl.glVertex3f(24,10,8);
            gl.glVertex3f(24,10,6);         
            gl.glEnd();
            
            
            gl.glBegin(gl.GL_QUADS);
            gl.glEnable(gl.GL_BLEND);
             gl.glColor3f(1.0f,0.5f,0.0f);
            gl.glVertex3f(16, 0, 6);
            gl.glVertex3f(16,10,6); 
            gl.glVertex3f(16,10,8);
            gl.glVertex3f(16,0,8);         
            gl.glEnd();    
                        
            
         
            gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(1.0f,0.5f,0.0f); 
             gl.glVertex3f(24, 0, 6);
             gl.glVertex3f(24,10, 6);
             gl.glVertex3f(24,10, 8);
             gl.glVertex3f(24,0, 8);
                      
            gl.glEnd();
            
              //columna 3
           //desde arriba columna
            gl.glBegin(gl.GL_QUADS);
            gl.glEnable(gl.GL_BLEND);
            gl.glColor3f(1.0f,0.5f,0.0f);
            gl.glVertex3f(16, 10, 9);
            gl.glVertex3f(16,10,11); 
            gl.glVertex3f(24,10,11);
            gl.glVertex3f(24,10,9);         
            gl.glEnd();
            
            
            gl.glBegin(gl.GL_QUADS);
            gl.glEnable(gl.GL_BLEND);
             gl.glColor3f(1.0f,0.5f,0.0f);
            gl.glVertex3f(16, 0, 9);
            gl.glVertex3f(16,10,9); 
            gl.glVertex3f(16,10,11);
            gl.glVertex3f(16,0,11);         
            gl.glEnd();    
                        
            
         
            gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(1.0f,0.5f,0.0f); 
             gl.glVertex3f(24, 0, 9);
             gl.glVertex3f(24,10, 9);
             gl.glVertex3f(24,10, 11);
             gl.glVertex3f(24,0, 11);
                      
            gl.glEnd();
            
             //columna 4
           //desde arriba columna
            gl.glBegin(gl.GL_QUADS);
            gl.glEnable(gl.GL_BLEND);
            gl.glColor3f(1.0f,0.5f,0.0f);
            gl.glVertex3f(16, 10, 12);
            gl.glVertex3f(16,10,14); 
            gl.glVertex3f(24,10,14);
            gl.glVertex3f(24,10,12);         
            gl.glEnd();
            
            
            gl.glBegin(gl.GL_QUADS);
            gl.glEnable(gl.GL_BLEND);
             gl.glColor3f(1.0f,0.5f,0.0f);
            gl.glVertex3f(16, 0, 12);
            gl.glVertex3f(16,10,12); 
            gl.glVertex3f(16,10,14);
            gl.glVertex3f(16,0,14);         
            gl.glEnd();    
                        
            
         
            gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(1.0f,0.5f,0.0f); 
             gl.glVertex3f(24, 0, 12);
             gl.glVertex3f(24,10, 12);
             gl.glVertex3f(24,10, 14);
             gl.glVertex3f(24,0, 14);
                      
            gl.glEnd();
            
            //columna 5
           //desde arriba columna
            gl.glBegin(gl.GL_QUADS);
            gl.glEnable(gl.GL_BLEND);
            gl.glColor3f(1.0f,0.5f,0.0f);
            gl.glVertex3f(16, 10, 15);
            gl.glVertex3f(16,10,17); 
            gl.glVertex3f(24,10,17);
            gl.glVertex3f(24,10,15);         
            gl.glEnd();
            
            
            gl.glBegin(gl.GL_QUADS);
            gl.glEnable(gl.GL_BLEND);
             gl.glColor3f(1.0f,0.5f,0.0f);
            gl.glVertex3f(16, 0, 15);
            gl.glVertex3f(16,10,15); 
            gl.glVertex3f(16,10,17);
            gl.glVertex3f(16,0,17);         
            gl.glEnd();    
                        
            
         
            gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(1.0f,0.5f,0.0f); 
             gl.glVertex3f(24, 0, 15);
             gl.glVertex3f(24,10, 15);
             gl.glVertex3f(24,10, 17);
             gl.glVertex3f(24,0, 17);
                      
            gl.glEnd();
            
             //columna 6
           //desde arriba columna
            gl.glBegin(gl.GL_QUADS);
            gl.glEnable(gl.GL_BLEND);
            gl.glColor3f(1.0f,0.5f,0.0f);
            gl.glVertex3f(16, 10, 18);
            gl.glVertex3f(16,10,20); 
            gl.glVertex3f(24,10,20);
            gl.glVertex3f(24,10,18);         
            gl.glEnd();
            
            
            gl.glBegin(gl.GL_QUADS);
            gl.glEnable(gl.GL_BLEND);
             gl.glColor3f(1.0f,0.5f,0.0f);
            gl.glVertex3f(16, 0, 20);
            gl.glVertex3f(16,10,18); 
            gl.glVertex3f(16,10,20);
            gl.glVertex3f(16,0,18);         
            gl.glEnd();    
                        
            
         
            gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(1.0f,0.5f,0.0f); 
             gl.glVertex3f(24, 0, 18);
             gl.glVertex3f(24,10, 18);
             gl.glVertex3f(24,10, 20);
             gl.glVertex3f(24,0, 20);
                      
            gl.glEnd();
            
             //columna 7
           //desde arriba columna
            gl.glBegin(gl.GL_QUADS);
            gl.glEnable(gl.GL_BLEND);
            gl.glColor3f(1.0f,0.5f,0.0f);
            gl.glVertex3f(16, 10, 21);
            gl.glVertex3f(16,10,23); 
            gl.glVertex3f(24,10,23);
            gl.glVertex3f(24,10,21);         
            gl.glEnd();
            
            
            gl.glBegin(gl.GL_QUADS);
            gl.glEnable(gl.GL_BLEND);
             gl.glColor3f(1.0f,0.5f,0.0f);
            gl.glVertex3f(16, 0, 23);
            gl.glVertex3f(16,10,21); 
            gl.glVertex3f(16,10,23);
            gl.glVertex3f(16,0,21);         
            gl.glEnd();    
                        
            
         
            gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(1.0f,0.5f,0.0f); 
             gl.glVertex3f(24, 0, 21);
             gl.glVertex3f(24,10, 21);
             gl.glVertex3f(24,10, 23);
             gl.glVertex3f(24,0, 23);
                      
            gl.glEnd();
            
                       
          
            
           //muro de venta de CD's
            gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(1.0f,0.5f,0.0f); 
             gl.glVertex3f(16, 0, 25);
             gl.glVertex3f(16,20, 25);
             gl.glVertex3f(16,20, 40);
             gl.glVertex3f(16,0,40);
           gl.glEnd(); 
                     
          
           //dibujando matricula financiera
            gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(1.0f,0.5f,0.0f); 
             gl.glVertex3f(0,0,25);
             gl.glVertex3f(0,20,25);
             gl.glVertex3f(0,20,40);
             gl.glVertex3f(0,0,40);
           gl.glEnd();
           
           gl.glBegin(gl.GL_QUADS);
            gl.glColor3f(1.0f,0.5f,0.0f); 
             gl.glVertex3f(0,20,25);
             gl.glVertex3f(16,20,25);
             gl.glVertex3f(16,20,40);
             gl.glVertex3f(0,20,40);
           gl.glEnd();
           
                    
           
           
          

            gl.glFlush();

        }

        public void init(GLAutoDrawable drawable) {
        }

        public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        }

        public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        }
    }

    //Se programan las teclas para manipular la camara
    public void keyPressed(KeyEvent arg0) {
       if(arg0.getKeyCode()==KeyEvent.VK_ESCAPE){
            rotarX=0;
            rotarY=0;
            rotarZ=0;
            trasladaX=0;
            trasladaY=0;
            trasladaZ=0;
        }
        if(arg0.getKeyCode()==KeyEvent.VK_X){
            rotarX+=2.0f;
            System.out.println("El valor de X en la rotacion: "+rotarX);
        }

        if(arg0.getKeyCode()==KeyEvent.VK_A){
            rotarX-=2.0f;
            System.out.println("El valor de X en la rotacion: "+rotarX);
        }

        if(arg0.getKeyCode()==KeyEvent.VK_Y){
            rotarY+=2.0f;
            System.out.println("El valor de Y en la rotacion: "+rotarY);
        } 

        if(arg0.getKeyCode()==KeyEvent.VK_B){
            rotarY-=2.0f;
            System.out.println("El valor de Y en la rotacion: "+rotarY);
        }

        if(arg0.getKeyCode()==KeyEvent.VK_Z){
            rotarZ+=2.0f;
            System.out.println("El valor de Z en la rotacion: "+rotarZ);
        }

        if(arg0.getKeyCode()==KeyEvent.VK_C){
            rotarZ-=2.0f;
            System.out.println("El valor de Z en la rotacion: "+rotarZ);
        }

        //Camara
        if(arg0.getKeyCode()==KeyEvent.VK_RIGHT){
            trasladaX+=.20f;
            System.out.println("Posicion de la camara en X: "+trasladaX);
        }

          if(arg0.getKeyCode()==KeyEvent.VK_LEFT){
            trasladaX-=.20f;
            System.out.println("Posicion de la camara en X: "+trasladaX);
        }

         if(arg0.getKeyCode()==KeyEvent.VK_UP){
            trasladaY+=.20f;
            System.out.println("Posicion de la camara en Y: "+trasladaY);
        }

          if(arg0.getKeyCode()==KeyEvent.VK_DOWN){
            trasladaY-=.20f;
            System.out.println("Posicion de la camara en Y: "+trasladaY);
          }

        if(arg0.getKeyCode()==KeyEvent.VK_1){
            trasladaZ+=.2;
            System.out.println("Posicion de la camara en Z: "+trasladaZ);
          }

        if(arg0.getKeyCode()==KeyEvent.VK_2){
            trasladaZ-=.20f;
            System.out.println("Posicion de la camara en Z: "+trasladaZ);
          }
        if(arg0.getKeyCode()==KeyEvent.VK_3){
            rotarY+=2.0;
            System.out.println("rotacion de la camara en Y: "+rotarY);
        }

        if(arg0.getKeyCode()==KeyEvent.VK_4){
            rotarY-=2.0;
            System.out.println("rotacion de la camara en Y: "+rotarY);
        }
    }

    public void keyTyped(KeyEvent e) {
    }
    public void keyReleased(KeyEvent e) {
    }
}
