package prop.crud;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParsePropertiesTest {
	
	private InputStream is =null;
	@Before
	public void setUp() throws Exception {
		is = ParseProperties.get("prop/crud/info.properties");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIteratorAll() throws IOException {
//		fail("Not yet implemented");
		
		Map<String,String> map = ParseProperties.iteratorAll(is);
		Set<String> set = map.keySet();
		for (String key : set) { 
			System.out.println(key +"  :  " + map.get(key)); 
		}
	}

	@Test
	public void testGetValueByKey() throws IOException {
//		fail("Not yet implemented");
		
		System.out.println(ParseProperties.getValueByKey(is, "ad_key05"));
	}

	@Test
	public void testInsert() throws IOException, URISyntaxException {
//		fail("Not yet implemented");
		ParseProperties.insert("prop/crud/info.properties", "ss", "ss_value");
	}

	@Test
	public void testDelete() throws URISyntaxException, IOException {
//		fail("Not yet implemented");
		ParseProperties.delete("prop/crud/info.properties", "ad_key02");
	}

	@Test
	public void testGetString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByteArray() {
		fail("Not yet implemented");
	}

}
