
package monpackage;

import javacard.framework.APDU;

import javacard.framework.Applet;
import javacard.framework.ISOException;
import javacard.framework.ISO7816;


public class MyApplet extends Applet {
	/*Constants*/
	public static final byte CLA_MONAPPLET = (byte) 0xB0;
	public static final byte INS_INCREMENTER_ARG = 0x00;
	public static final byte INS_DECREMENTER_ARG = 0x01;
	public static final byte INS_INTERROGER_ARG = 0x02; 
	public static final byte INS_TRANSFERER_ARG = 0x03;
	
	 /* Attributs */
	 private byte montant;

		
	/* Constructeur */
	 
	private MyApplet() {
		montant = 0;
	}
	
	public static void install(byte bArray[], short bOffset, byte bLength) 
		throws ISOException {
		
		new MyApplet().register();
	
	}
	

	public void process(APDU apdu) throws ISOException {
		// TODO Auto-generated method stub
		
		byte[] buffer = apdu.getBuffer();
		if (this.selectingApplet()) return;
		if (buffer[ISO7816.OFFSET_CLA] != CLA_MONAPPLET) {
		ISOException.throwIt(ISO7816.SW_CLA_NOT_SUPPORTED);
		}
		switch (buffer[ISO7816.OFFSET_INS]) {
		case INS_INCREMENTER_ARG:
			
		apdu.setIncomingAndReceive();
			
		montant += buffer[ISO7816.OFFSET_CDATA];
			
		break;
		case INS_DECREMENTER_ARG:

		apdu.setIncomingAndReceive();
		
		montant-=(byte) buffer[ISO7816.OFFSET_CDATA];
		
		break;
		
		case INS_INTERROGER_ARG:
			
		buffer[0] = montant;
		apdu.setOutgoingAndSend((short) 0, (short) 1);
		
		break;
		 case INS_TRANSFERER_ARG:
			 apdu.setIncomingAndReceive();
				
				montant-=(byte) buffer[ISO7816.OFFSET_CDATA];
				
		break;
		default:
			
			ISOException.throwIt(ISO7816.SW_INS_NOT_SUPPORTED);
		}
	
	}
		


}
       