import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.nitido.utils.toaster.Example;

import syntaxhighlight.SyntaxHighlighter;
import syntaxhighlighter.SyntaxHighlighterParser;
import syntaxhighlighter.brush.BrushCss;
import syntaxhighlighter.brush.BrushJScript;
import syntaxhighlighter.brush.BrushJava;
import syntaxhighlighter.brush.BrushPhp;
import syntaxhighlighter.brush.BrushXml;
import syntaxhighlighter.theme.ThemeDefault;
import syntaxhighlighter.theme.ThemeRDark;


public class QuickCodeInspector {
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	        SyntaxHighlighterParser parser = new SyntaxHighlighterParser(new BrushJava());
	        parser.setHtmlScript(true);
	        parser.setHTMLScriptBrushes(Arrays.asList(new BrushCss(), new BrushJScript(), new BrushPhp()));
	        SyntaxHighlighter highlighter = new SyntaxHighlighter(parser, new ThemeDefault());
	        highlighter.setFirstLine(1);

	        try {
	          highlighter.setContent(new File("/home/kal0ian/HBJava/week1/2-OOP/src/StackImpl.java"));
	        } catch (IOException ex) {
	          Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
	        }

	        JFrame frame = new JFrame();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setContentPane(highlighter);
	        frame.setLocationByPlatform(true);
	        frame.pack();
	        frame.setVisible(true);
	      }
	    });
	  }

}
