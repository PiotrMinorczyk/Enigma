package application;

import static org.junit.Assert.*;

import org.junit.Test;

public class EnigmaTest {

	@Test
	public void encryptAndDecryptTheCorrectChar() {
		String code = "QWERTYUIOPASDFGHJKLZXCVBNM ";
		String code2;
		code2 = Enigma.codeText(code);
		code2 = Enigma.codeText(code2);
		assertEquals("failure - not aqualse", code, code2);
	}

	@Test
	public void encryptAndDecryptTheWrongChar() {

		String code = "qwertyuiopasdfghjklzxcvbnm[];',./{}:<>?1234567890-=!@#$%^&*()_+";
		String code2;
		code2 = Enigma.codeText(code);
		assertEquals("failure - not aqualse", "***************************************************************", code2);

	}

}
