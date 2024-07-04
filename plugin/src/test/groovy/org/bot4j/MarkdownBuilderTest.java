package org.bot4j;

import org.bot4j.telegram.message.MarkdownBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarkdownBuilderTest {

    private MarkdownBuilder builder;

    @Before
    public void setUp() {
        builder = new MarkdownBuilder();
    }

    @Test
    public void testVertical() {
        String result = builder.vertical("text").toString();
        assertEquals("||text|| ", result);
    }

    @Test
    public void testBold() {
        String result = builder.bold("text").toString();
        assertEquals("*text* ", result);
    }

    @Test
    public void testItalic() {
        String result = builder.italic("text").toString();
        assertEquals("_text_ ", result);
    }

    @Test
    public void testStrikethrough() {
        String result = builder.strikethrough("text").toString();
        assertEquals("~text~ ", result);
    }

    @Test
    public void testUnderline() {
        String result = builder.underline("text").toString();
        assertEquals("__text__ ", result);
    }

    @Test
    public void testCode() {
        String result = builder.code("text").toString();
        assertEquals("`text` ", result);
    }

    @Test
    public void testPreformatted() {
        String result = builder.preformatted("text").toString();
        assertEquals("```text``` ", result);
    }

    @Test
    public void testPreformattedWithLang() {
        String result = builder.preformatted("java", "text").toString();
        assertEquals("```java text``` ", result);
    }

    @Test
    public void testLink() {
        String result = builder.link("text", "http://example.com").toString();
        assertEquals("[text](http://example.com) ", result);
    }

    @Test
    public void testText() {
        String result = builder.text("text").toString();
        assertEquals("text ", result);
    }

    @Test
    public void testLine() {
        String result = builder.line().toString();
        assertEquals(System.lineSeparator() + " ", result);
    }

    @Test
    public void testLineWithRepeat() {
        String result = builder.line(2).toString();
        assertEquals(System.lineSeparator().repeat(2) + " ", result);
    }

    @Test
    public void testSpace() {
        String result = builder.space().toString();
        assertEquals(" ", result);
    }

    @Test
    public void testSpaceWithRepeat() {
        String result = builder.space(2).toString();
        assertEquals("  ", result);
    }
}
