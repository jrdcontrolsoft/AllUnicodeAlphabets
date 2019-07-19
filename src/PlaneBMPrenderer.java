import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.TreeMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class PlaneBMPrenderer extends DefaultTableCellRenderer {
	
	//TreeMap<Character.UnicodeBlock, Color> blockColor 
	//	= new TreeMap<Character.UnicodeBlock, Color>();
	TreeMap<Integer, Color> blockColor = new TreeMap<Integer, Color>();
	
	public Component getTableCellRendererComponent(JTable table, Object value, 
			boolean isSelected, boolean hasFocus, int row, int column) {
    	Component stdRend = super.getTableCellRendererComponent(table, value, isSelected, hasFocus
        	, row, column);
    	//font calc
    	int dimCount = 256;
    	int codepoint = (row*dimCount)+column;
    	/*
		if (Character.isValidCodePoint(codepoint)) {
            sb.append((char) codepoint);
		}
		*/
    	//generic row (x) 0 -> green, col (y) 0 -> blue
    	if (((String)value).length()!=0) {
        	//stdRend.setBackground(new Color(255, row, column));
    		//Color bgdColor = (Color)(blockColor.ceilingEntry(Character.UnicodeBlock.of(codepoint)));
    		Color bgdColor = blockColor.get(blockColor.ceilingKey(codepoint));
    		stdRend.setBackground(bgdColor);
    	} else {
        	stdRend.setBackground(Color.WHITE);
    	}
    	//gray out UTF-16 surrogates (always shown)
    	if (codepoint>=0xD800 && codepoint<0xE000) {
    		stdRend.setBackground(Color.GRAY);
    	}
    	return stdRend;
	}
	
	
	//Constructor
	public PlaneBMPrenderer() {
		super();
		//set the color divisions of BMP blocks
		//roughly based on colors in "Roadmap to Unicode" chart
		/*
		blockColor.put(Character.UnicodeBlock.SPACING_MODIFIER_LETTERS, new Color(64,64,64));
		blockColor.put(Character.UnicodeBlock.ARMENIAN, new Color(64,64,255));
		
		blockColor.put(Character.UnicodeBlock.SPECIALS, new Color(255,165,0));
		*/
		Color latin = new Color(192,192,192);
		Color nonLatin = new Color(128,128,255);
		Color midEastern = new Color(255,165,0);
		Color southAsian = new Color(0,255,0);
		Color african = new Color(144,238,144);
		Color southeastAsian = new Color(255,64,255);
		Color eastAsian = new Color(255,60,100);
		Color american = new Color(255,255,0);
		Color oceanic = new Color(160,82,45);
		Color symbols = new Color(255,192,255);
		Color notational = new Color(0,255,255);
		Color cjk = new Color(250,128,114);
		Color privateuse = new Color(170,170,170);
		
		blockColor.put(0x02FF, latin);			//Character.UnicodeBlock.SPACING_MODIFIER_LETTERS
		blockColor.put(0x058F, nonLatin);		//Character.UnicodeBlock.ARMENIAN
		blockColor.put(0x077F, midEastern);		//Character.UnicodeBlock.ARABIC [Supplement]
		blockColor.put(0x07BF, southAsian);		//Character.UnicodeBlock.THAANA
		blockColor.put(0x07FF, african);		//Character.UnicodeBlock.[N'Ko]
		blockColor.put(0x08FF, midEastern);		//Character.UnicodeBlock.ARABIC [Extended]
		blockColor.put(0x0DFF, southAsian);		//Character.UnicodeBlock.SINHALA
		blockColor.put(0x0EFF, southeastAsian);	//Character.UnicodeBlock.LAO
		blockColor.put(0x0FFF, southAsian);		//Character.UnicodeBlock.TIBETAN
		blockColor.put(0x109F, southeastAsian);	//Character.UnicodeBlock.MYANMAR
		blockColor.put(0x10FF, nonLatin);		//Character.UnicodeBlock.GEORGIAN
		blockColor.put(0x11FF, eastAsian);		//Character.UnicodeBlock.HANGUL_JAMO
		blockColor.put(0x139F, african);		//Character.UnicodeBlock.ETHIOPIC [Supplement]
		blockColor.put(0x167F, american);		//Character.UnicodeBlock.UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS
		blockColor.put(0x16FF, nonLatin);		//Character.UnicodeBlock.RUNIC
		blockColor.put(0x177F, oceanic);		//Character.UnicodeBlock.TAGBANWA
		blockColor.put(0x17FF, southeastAsian);	//Character.UnicodeBlock.KHMER
		blockColor.put(0x18AF, southAsian);		//Character.UnicodeBlock.MONGOLIAN
		blockColor.put(0x18FF, american);		//Character.UnicodeBlock.UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS [Extended]
		blockColor.put(0x194F, southAsian);		//Character.UnicodeBlock.LIMBU
		blockColor.put(0x1AAF, southeastAsian);	//Character.UnicodeBlock.[Tai Tham]
		blockColor.put(0x1AFF, nonLatin);		//Character.UnicodeBlock.COMBINING_DIACRITICAL_MARKS [Extended]
		blockColor.put(0x1BFF, oceanic);		//Character.UnicodeBlock.[Batak]
		blockColor.put(0x1C7F, southAsian);		//Character.UnicodeBlock.[Ol Chiki]
		blockColor.put(0x1CBF, nonLatin);		//Character.UnicodeBlock.GEORGIAN [Extended]
		blockColor.put(0x1CCF, african);		//Character.UnicodeBlock.[Sudanese Extensions]
		blockColor.put(0x1CFF, southAsian);		//Character.UnicodeBlock.[Vedic Extensions]
		blockColor.put(0x1DBF, latin);			//Character.UnicodeBlock.PHONETIC_EXTENSIONS [Supplement]
		blockColor.put(0x1DFF, nonLatin);		//Character.UnicodeBlock.COMBINING_DIACRITICAL_MARKS [Supplement]
		blockColor.put(0x1EFF, latin);			//Character.UnicodeBlock.LATIN_EXTENDED_ADDITIONAL
		blockColor.put(0x209F, nonLatin);		//Character.UnicodeBlock.SUPERSCRIPTS_AND_SUBSCRIPTS
		blockColor.put(0x27FF, symbols);		//Character.UnicodeBlock.SUPPLEMENTAL_ARROWS_A
		blockColor.put(0x28FF, notational);		//Character.UnicodeBlock.BRAILLE_PATTERNS
		blockColor.put(0x2BFF, symbols);		//Character.UnicodeBlock.MISCELLANEOUS_SYMBOLS_AND_ARROWS
		blockColor.put(0x2C5F, nonLatin);		//Character.UnicodeBlock.[Glagolitic]
		blockColor.put(0x2C7F, latin);			//Character.UnicodeBlock.LATIN_EXTENDED_[C]
		blockColor.put(0x2D2F, nonLatin);		//Character.UnicodeBlock.GEORGIAN [Supplement]
		blockColor.put(0x2DDF, african);		//Character.UnicodeBlock.ETHIOPIC [Extended]
		blockColor.put(0x2DFF, nonLatin);		//Character.UnicodeBlock.CYRILLIC [Extended]
		blockColor.put(0x2E7F, symbols);		//Character.UnicodeBlock.SUPPLEMENTAL_[Punctuation]
		blockColor.put(0x2FFF, cjk);			//Character.UnicodeBlock.IDEOGRAPHIC_DESCRIPTION_CHARACTERS
		blockColor.put(0x31BF, eastAsian);		//Character.UnicodeBlock.BOPOMOFO_EXTENDED
		blockColor.put(0x31EF, cjk);			//Character.UnicodeBlock.CJK_[Strokes]
		blockColor.put(0x31FF, eastAsian);		//Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS
		blockColor.put(0x33FF, symbols);		//Character.UnicodeBlock.CJK_COMPATIBILITY
		blockColor.put(0x4DBF, cjk);			//Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
		blockColor.put(0x4DFF, symbols);		//Character.UnicodeBlock.YIJING_HEXAGRAM_SYMBOLS
		blockColor.put(0x9FFF, cjk);			//Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
		blockColor.put(0xA4FF, eastAsian);		//Character.UnicodeBlock.[Lisu]
		blockColor.put(0xA63F, african);		//Character.UnicodeBlock.[Vai]
		blockColor.put(0xA69F, nonLatin);		//Character.UnicodeBlock.CYRILLIC [Extended B]
		blockColor.put(0xA6FF, african);		//Character.UnicodeBlock.[Bamum]
		blockColor.put(0xA71F, eastAsian);		//Character.UnicodeBlock.[Modifier Tone Letters]
		blockColor.put(0xA7FF, latin);			//Character.UnicodeBlock.LATIN_EXTENDED_[D]
		blockColor.put(0xA82F, southAsian);		//Character.UnicodeBlock.[Syloti Nagri]
		blockColor.put(0xA83F, symbols);		//Character.UnicodeBlock.[Common Indic Number Forms]
		blockColor.put(0xA8FF, southAsian);		//Character.UnicodeBlock.DEVANAGARI [Extended]
		blockColor.put(0xA92F, southeastAsian);	//Character.UnicodeBlock.[Kayah Li]
		blockColor.put(0xA95F, oceanic);		//Character.UnicodeBlock.[Rejang]
		blockColor.put(0xA97F, eastAsian);		//Character.UnicodeBlock.HANGUL_JAMO [Extended-A]
		blockColor.put(0xA9DF, oceanic);		//Character.UnicodeBlock.[Javanese]
		blockColor.put(0xAADF, southeastAsian);	//Character.UnicodeBlock.[Tai Viet]
		blockColor.put(0xAAFF, southAsian);		//Character.UnicodeBlock.[Meetei Mayek Extensions]
		blockColor.put(0xAB2F, african);		//Character.UnicodeBlock.ETHIOPIC [Extended-A]
		blockColor.put(0xAB6F, latin);			//Character.UnicodeBlock.LATIN_EXTENDED_[E]
		blockColor.put(0xABBF, american);		//Character.UnicodeBlock.CHEROKEE [Supplement]
		blockColor.put(0xABFF, southAsian);		//Character.UnicodeBlock.[Meetei Mayek]
		blockColor.put(0xD7FF, eastAsian);		//Character.UnicodeBlock.HANGUL_JAMO [Extended-B]
		blockColor.put(0xF8FF, privateuse);		//Character.UnicodeBlock.PRIVATE_USE_AREA
		blockColor.put(0xFAFF, cjk);			//Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
		blockColor.put(0xFB4F, nonLatin);		//Character.UnicodeBlock.ALPHABETIC_PRESENTATION_FORMS
		blockColor.put(0xFDFF, midEastern);		//Character.UnicodeBlock.ARABIC_PRESENTATION_FORMS_A
		blockColor.put(0xFE0F, eastAsian);		//Character.UnicodeBlock.VARIATION_SELECTORS
		blockColor.put(0xFE1F, nonLatin);		//Character.UnicodeBlock.[Vertical Forms]
		blockColor.put(0xFE6F, eastAsian);		//Character.UnicodeBlock.SMALL_FORM_VARIANTS
		blockColor.put(0xFEFF, midEastern);		//Character.UnicodeBlock.ARABIC_PRESENTATION_FORMS_B
		blockColor.put(0xFFFF, eastAsian);		//Character.UnicodeBlock.SPECIALS (last)
	}
	
	/*
	public PlaneBMPrenderer(Font uniFont) {
		super();
		internFont = uniFont;
	}
	*/
}
