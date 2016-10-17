import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/*
 * Assignment 4, 
 * 
 * This is a fresh copy of Picture.java created specifically for Assignment4.
 * 
 * 
 */

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */

public class Picture extends SimplePicture 
{
  
///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  
  
  
  /*
   * Week 4: Assignment: extracts bird from cricketer picture and places it on 
   * the beach
   * 
   * 	382, 340, 444, 390
   */
  public void chromakeyAssignment(Picture background, int x, int y, int width, int height)	
  {
	  
	  // Create Pixel object
	  Pixel currPixel = null;
	  Pixel newPixel = null;
	  
	  // color settings for filtering out image from another picture
   	  int colorThreshold = 90;
   	  int colorTotal = 140;
   	  
   	  // local x & y positions
	  int posX;
	  int posY;
	  
	  // step through the columns
	  for ( posX = x; posX < width; posX++)
	  {
		  // step through the rows
		  for ( posY = y; posY < height; posY++)
		  {
			  // get color from subject
			  currPixel = this.getPixel(posX, posY);
			  
			  // create the filter for separating the darkest part of the selected image
			  if ( currPixel.getRed() < colorThreshold || currPixel.getGreen() < colorThreshold 
					  || currPixel.getBlue() < colorThreshold && (currPixel.getRed() 
					  + currPixel.getGreen() + currPixel.getBlue() < colorTotal) ) 
			  {
				  newPixel = background.getPixel(posX - 120, posY - 55);
				  newPixel.setColor(currPixel.getColor());
			  }
		  }
	  }
  }
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
 
  public static void main(String[] args) 
  {
	  
	  
	  //Assignment
	  Picture subject = new Picture(FileChooser.getMediaPath("oxford-cricketers.jpg"));	
	  Picture background = new Picture(FileChooser.getMediaPath("beach.jpg"));	
	  subject.chromakeyAssignment(background, 382, 340, 444, 390);
	  background.show();
	  
	  
  }
  
} // this } is the end of class Picture, put all new methods before this
 