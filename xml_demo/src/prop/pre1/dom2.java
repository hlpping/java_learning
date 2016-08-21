package prop.pre1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class dom2 {
	
	static final DocumentBuilderFactory df ;
	static {
		df = DocumentBuilderFactory
		.newInstance() ;
		df.setNamespaceAware(true) ;
	}

	static public Document get(File f) 
	throws Exception {
		BufferedInputStream bi = new 
		BufferedInputStream
		(new FileInputStream(f)) ;
		Document d = get(bi) ;
		bi.close() ;
		return d ; 
	}
	
	static public Document get
	(InputStream i) throws Exception { 
		return df.newDocumentBuilder()
		.parse(i) ;
	}
	
	static public Document get 
	(byte[] chunk) throws Exception { 
		return get
		(new ByteArrayInputStream(chunk)) ;
	}
	
	static public Document get
	(String str) throws Exception { 
		return get(str.getBytes("UTF-8")) ;
	}
	
	static public void write 
	(Document doc , OutputStream o) 
	throws Exception { 
		DOMSource s= new DOMSource(doc);
		StreamResult r = new StreamResult(o);
		Transformer t = TransformerFactory
		.newInstance().newTransformer();
		t.setOutputProperty
		(OutputKeys.ENCODING,"UTF-8");
		t.setOutputProperty
		(OutputKeys.INDENT,"yes");
		t.transform(s,r);
	}
	
	static public void write 
	(Document doc, File f) 
	throws Exception { 
		BufferedOutputStream bo = new 
		BufferedOutputStream
		(new FileOutputStream(f)) ;
		write(doc, bo) ;
		bo.close() ;
	}
	
	static public void print(Document doc) 
	throws Exception {
		System.out.println
		(doc_string(doc)) ;
	}
	
	static public String 
	doc_string(Document doc) 
	throws Exception {
		byte[] chunk = doc_chunk(doc) ;
		String s = new String
		(chunk,"UTF-8") ;
		return s ;
	}
	
	static public byte[] doc_chunk
	(Document doc) throws Exception { 
		ByteArrayOutputStream bos 
		= new ByteArrayOutputStream() ;
		write(doc,bos) ;
		return bos.toByteArray() ;
	}
	
	static public Document new_doc() { 
		Document d = null ;
		try { 
			d = df.newDocumentBuilder()
			.newDocument() ;
		} catch (Exception exc) { 
		}
		return d ;
	}
	
	static public Node get_node  
	(Node p, String node_name) { 
		NodeList nl = p.getChildNodes() ;
		Node n = null ;
		for (int i=0; i<nl.getLength(); i++) { 
			Node nc = nl.item(i) ;
			if (nc.getNodeName().equals(node_name)) {
				n = nc ;
				break ;
			}
		}
		return n ;
	}
	
	public static String attr_value 
	( Node n  , String f ) {
		try { 
			return attr_exc(n,f) ;
		} catch (Exception exc) { 
			return null ;
		}
	}

	public static String attr_exc 
	( Node n , String f ) 
	throws Exception { 
		if (n==null) throw new Exception 
		("null node") ;
		NamedNodeMap nm = n.getAttributes() ;
		if (nm==null||nm.getLength()==0) throw 
		new Exception ("null attr list for node") ;
		n = nm.getNamedItem(f) ;
		if (n==null) throw new Exception
		("attr_name not found: " + f) ;
		return n.getNodeValue() ;
	}
	
	public static int attr_int 
	(Node n, String f) 
	throws Exception {
		String val = attr_exc(n,f) ;
		return Integer.parseInt(val) ;
	}

	public static long attr_long 
	(Node n, String f) 
	throws Exception {
		String val = attr_exc(n,f) ;
		return Long.parseLong(val) ;
	}
	//
	//
	// ...
	//     <servers>
	//			<server value="71"/>
	//			<server value="72"/>
	//     </servers>
	
	public static List<String> param_array
	(Node cn, String node_name) { 
		List<String> rtv = new ArrayList<String>() ;
		if (cn==null) return rtv ;
		for (Node n:node_array(cn,node_name)) {
			try {
				rtv.add(attr_exc(n,"value")) ;
			} catch (Exception exc) { 
				continue ;
			}
		}
		return rtv ;
	}
	
	public static List<Node> node_array 
	(Node cn , String node_name) { 
		List<Node> rtv = new ArrayList<Node>() ;
		if (cn==null) return rtv ;
		NodeList nl = cn.getChildNodes() ;
		for (int i=0 ; i<nl.getLength() ; i++ ) {
			cn = nl.item(i) ;
			if (cn.getNodeName()
			.equals(node_name)) rtv
			.add(cn) ;
		}
		return rtv;
	}
	
	public static List<Node> sub_nodes 
	(Node cn) { 
		List<Node> rtv = new ArrayList<Node>() ;
		if (cn==null) return rtv ;
		NodeList nl = cn.getChildNodes() ;
		for (int i=0 ; i<nl.getLength() ; 
		i++ ) {
			Node n = nl.item(i) ;
			String nn = n.getNodeName() ;
			if ("#text".equals(nn)) continue ;
			rtv.add(n) ;
		}
		return rtv;
	}

	public static void set_array
	(Node parent, String name, List<Object> params) { 
		Document doc = parent
		.getOwnerDocument() ;
		for (Object p:params) { 
			Element ele = doc
			.createElement(name) ;
			attr_value
			(ele,String.valueOf(p)) ;
			parent.appendChild(ele) ;
		}
	}
	
	public static void set_attr
	(Element e, String key , Object value) { 
		e.setAttribute
		(key, String.valueOf(value)) ;
	}

	public static Element empty_ele 
	(Element parent, String sub) {
		Element sube = parent
		.getOwnerDocument()
		.createElement(sub) ;
		parent.appendChild(sube) ;
		return sube ;
	}

	public static Element value_ele
	(Element parent, String name, 
	String value) {
		Document doc = parent
		.getOwnerDocument() ;
		Element sub = doc
		.createElement(name) ;
		parent.appendChild(sub) ;
		Text text = doc
		.createTextNode(value) ;
		sub.appendChild(text) ;
		return sub ;
	}
	
	public static Map<String,String> attr_map 
	( Node n )  throws Exception {
		Map<String,String> attrs = new 
		HashMap<String,String>() ;
		if (n==null) throw new Exception 
		("null node") ;
		NamedNodeMap nm = n.getAttributes() ;
		if (nm==null||nm.getLength()==0) return
		attrs ;
		
		for (int i=0; i<nm.getLength(); i++) { 
			Node nn = nm.item(i) ;
			String k = nn.getNodeName() ,
			v = nn.getNodeValue() ; 
			attrs.put(k,v) ;
		}
		
		return attrs ;
	}
	
}
