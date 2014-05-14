/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystem;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author Pieter Pletinckx
 */
public class DocModel {
    private final String templateLocation = "/resources/stageovereenkomstTemplate_1415TI.docx";
    
    public void maakStageOvereenkomst() throws IOException{
    InputStream resourceAsStream =  getClass().getResourceAsStream(templateLocation);       
        XWPFDocument template = new XWPFDocument(resourceAsStream); 
        
    }
}
