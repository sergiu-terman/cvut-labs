package com.ddw.hw1;


import gate.Annotation;
import gate.AnnotationSet;
import gate.Corpus;
import gate.CreoleRegister;
import gate.Document;
import gate.Factory;
import gate.FeatureMap;
import gate.Gate;
import gate.Node;
import gate.ProcessingResource;
import gate.creole.SerialAnalyserController;
import gate.util.GateException;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Milan Dojchinovski
 * <milan (at) dojchinovski (dot) mk>
 * Twitter: @m1ci
 * www: http://dojchinovski.mk
 */
public class GateClient {
    
    // corpus pipeline
    private static SerialAnalyserController annotationPipeline = null;
    
    // whether the GATE is initialised
    private static boolean isGateInitilised = false;
    
    public void run(){
        
        if(!isGateInitilised){
            
            // initialise GATE
            initialiseGate();            
        }        

        try {                
            // create an instance of a Document Reset processing resource
            ProcessingResource documentResetPR = (ProcessingResource) Factory.createResource("gate.creole.annotdelete.AnnotationDeletePR");

            // create an instance of a Sentence Splitter processing resource
            ProcessingResource sentenceSplitterPR = (ProcessingResource) Factory.createResource("gate.creole.splitter.SentenceSplitter");
            
            ProcessingResource nlpTokenizer = (ProcessingResource) Factory.createResource("gate.creole.tokeniser.DefaultTokeniser");
            
            ProcessingResource posTagger = (ProcessingResource) Factory.createResource("gate.creole.POSTagger");
            
            // locate the JAPE grammar file
            File japeOrigFile = new File("/home/sergiu/Downloads/jape-example2.jape");
            java.net.URI japeURI = japeOrigFile.toURI();
            
            // create feature map for the transducer
            FeatureMap transducerFeatureMap = Factory.newFeatureMap();
            try {
                // set the grammar location
                transducerFeatureMap.put("grammarURL", japeURI.toURL());
                // set the grammar encoding
                transducerFeatureMap.put("encoding", "UTF-8");
            } catch (MalformedURLException e) {
                System.out.println("Malformed URL of JAPE grammar");
                System.out.println(e.toString());
            }
            
            // create an instance of a JAPE Transducer processing resource
            ProcessingResource japeTransducerPR = (ProcessingResource) Factory.createResource("gate.creole.Transducer", transducerFeatureMap);

            // create corpus pipeline
            annotationPipeline = (SerialAnalyserController) Factory.createResource("gate.creole.SerialAnalyserController");

            // add the processing resources (modules) to the pipeline
            annotationPipeline.add(documentResetPR);
            annotationPipeline.add(sentenceSplitterPR);
            annotationPipeline.add(nlpTokenizer);
            annotationPipeline.add(posTagger);
            annotationPipeline.add(japeTransducerPR);
            
            // create a document
            Document document = Factory.newDocument("The International Business Machines Corporation (IBM) is an American multinational technology and consulting corporation, with headquarters in Armonk, New York, United States. IBM manufactures and markets computer hardware and software, and offers infrastructure, hosting and consulting services in areas ranging from mainframe computers to nanotechnology.[3] The company was founded in 1911 baliprestigeho@dps.centrin.net.id as the Computing Tabulating Recording Company (CTR) through a merger of three companies: the Tabulating Machine Company, the International Time Recording Company, and the Computing Scale Company.[4][5] CTR adopted the name International Business Machines in 1924, using a name previously designated to CTR's subsidiary in Canada and later South America. christian_rizal@interconti.com Securities analysts nicknamed IBM Big Blue in recognition of IBM's common use of blue in products, packaging, and logo.[6] In 2012, Fortune ranked IBM the No. 2 largest U.S. firm in terms of number of employees (435,000 worldwide,[7] approximately 100,000 in the US[8]), the No. 4 largest in terms of market capitalization,[9] the No. 9 most profitable,[10] and the No. 19 largest firm in terms of revenue.[11] Globally, the company was ranked the No. 31 largest in terms of revenue by Forbes for 2011.[12][13] Other rankings for 2011/2012 include No. 1 company for leaders (Fortune), No. 1 green company worldwide (Newsweek), No. 2 best global brand (Interbrand), No. 2 most respected company (Barron's), No. 5 most admired company (Fortune), and No. 18 most innovative company (Fast Company).[14] IBM has 12 research laboratories worldwide and, as of 2013, has held the record for most patents generated by a company hr@astonbali.com for 20 consecutive years.[15] Its employees have garnered five Nobel Prizes, six Turing Awards, ten National Medals of Technology, and five National Medals of Science.[16] Notable inventions by IBM include the automated teller machine (ATM), the floppy disk, the hard disk drive, the magnetic stripe card, the relational database, the Universal Product Code (UPC), the financial swap, the RDBMS and SQL, SABRE airline bounty@indo.net.id, reservation system, DRAM, and Watson artificial intelligence sm@ramayanahotel.com The company has undergone several organizational changes since its inception, acquiring companies such as Kenexa (2012) and SPSS (2009) and organizations such as PwC's consulting business (2002), spinning off companies like Lexmark (1991), and selling off product lines like ThinkPad to Lenovo (2005).");

            // create a corpus and add the document
            Corpus corpus = Factory.newCorpus("");
            corpus.add(document);

            // set the corpus to the pipeline
            annotationPipeline.setCorpus(corpus);

            //run the pipeline
            annotationPipeline.execute();

            // loop through the documents in the corpus
            for(int i=0; i< corpus.size(); i++){

                Document doc = corpus.get(i);

                // get the default annotation set
                AnnotationSet as_default = doc.getAnnotations();

                FeatureMap futureMap = null;
                // get all Token annotations
                AnnotationSet annSetTokens = as_default.get("Mention",futureMap);
                System.out.println("Number of Mentioned annotations: " + annSetTokens.size());

                ArrayList tokenAnnotations = new ArrayList(annSetTokens);

                // looop through the Token annotations
                for(int j = 0; j < tokenAnnotations.size(); ++j) {

                    // get a token annotation
                    Annotation token = (Annotation)tokenAnnotations.get(j);

                    // get the underlying string for the Token
                    Node isaStart = token.getStartNode();
                    Node isaEnd = token.getEndNode();
                    String underlyingString = doc.getContent().getContent(isaStart.getOffset(), isaEnd.getOffset()).toString();
                    System.out.println("Token: " + underlyingString);
                    
                    // get the features of the token
                    FeatureMap annFM = token.getFeatures();
                    
                    // get the value of the "string" feature
                    //String value = (String)annFM.get((Object)"string");
                    //System.out.println("Token: " + value);
                }
            }
        } catch (GateException ex) {
            Logger.getLogger(GateClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initialiseGate() {
        
        try {
            // set GATE home folder
            // Eg. /Applications/GATE_Developer_7.0
            File gateHomeFile = new File("/home/sergiu/Downloads/gate-7.1-build4485-BIN");
            Gate.setGateHome(gateHomeFile);
            
            // set GATE plugins folder
            // Eg. /Applications/GATE_Developer_7.0/plugins            
            File pluginsHome = new File("/home/sergiu/Downloads/gate-7.1-build4485-BIN/plugins");
            Gate.setPluginsHome(pluginsHome);            
            
            // set user config file (optional)
            // Eg. /Applications/GATE_Developer_7.0/user.xml
            Gate.setUserConfigFile(new File("/home/sergiu/Downloads/gate-7.1-build4485-BIN", "user.xml"));            
            
            // initialise the GATE library
            Gate.init();
            
            // load ANNIE plugin
            CreoleRegister register = Gate.getCreoleRegister();
            URL annieHome = new File(pluginsHome, "ANNIE").toURL();
            URL opennplHome = new File(pluginsHome, "OpenNLP").toURL();
            register.registerDirectories(annieHome);
            register.registerDirectories(opennplHome);
            
            // flag that GATE was successfuly initialised
            isGateInitilised = true;
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(GateClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GateException ex) {
            Logger.getLogger(GateClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}