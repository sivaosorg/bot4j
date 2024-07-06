package org.bot4j;

import org.bot4j.telegram.message.HtmlBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HtmlBuilderTest {

    @Test
    public void testBold() {
        HtmlBuilder builder = new HtmlBuilder();
        builder.bold("bold text");
        assertEquals("<b>bold text</b> ", builder.toString());
    }

    @Test
    public void testItalic() {
        HtmlBuilder builder = new HtmlBuilder();
        builder.italic("italic text");
        assertEquals("<i>italic text</i> ", builder.toString());
    }

    @Test
    public void testUnderline() {
        HtmlBuilder builder = new HtmlBuilder();
        builder.underline("underline text");
        assertEquals("<u>underline text</u> ", builder.toString());
    }

    @Test
    public void testPreformatted() {
        HtmlBuilder builder = new HtmlBuilder();
        builder.preformatted("preformatted text");
        assertEquals("<pre>preformatted text</pre> ", builder.toString());
    }

    @Test
    public void testPreformattedWithLang() {
        HtmlBuilder builder = new HtmlBuilder();
        builder.preformatted("java", "import org.bot4j.telegram.message.HtmlBuilder;");
        assertEquals("<pre><code class=\\\"language-java\\\">import org.bot4j.telegram.message.HtmlBuilder;</code></pre> ", builder.toString());
    }

    @Test
    public void testVertical() {
        HtmlBuilder builder = new HtmlBuilder();
        builder.vertical("vertical text");
        assertEquals("||vertical text|| ", builder.toString());
    }

    @Test
    public void testInlineUrl() {
        HtmlBuilder builder = new HtmlBuilder().link("OpenAI", "https://www.openai.com");
        assertEquals("<a href=\\\"https://www.openai.com\\\">OpenAI</a> ", builder.toString());
    }

    @Test
    public void testStrong() {
        HtmlBuilder builder = new HtmlBuilder();
        builder.strong("strong text");
        assertEquals("<strong>strong text</strong> ", builder.toString());
    }

    @Test
    public void testStrikethrough() {
        HtmlBuilder builder = new HtmlBuilder();
        builder.strikethrough("strikethrough text");
        assertEquals("<s>strikethrough text</s> ", builder.toString());
    }

    @Test
    public void testText() {
        HtmlBuilder builder = new HtmlBuilder();
        builder.text("simple text");
        assertEquals("simple text ", builder.toString());
    }

    @Test
    public void testCode() {
        HtmlBuilder builder = new HtmlBuilder();
        builder.code("code text");
        assertEquals("<code>code text</code> ", builder.toString());
    }

    @Test
    public void testDelete() {
        HtmlBuilder builder = new HtmlBuilder();
        builder.delete("delete text");
        assertEquals("<del>delete text</del> ", builder.toString());
    }

    @Test
    public void testSpoiler() {
        HtmlBuilder builder = new HtmlBuilder();
        builder.spoiler("spoiler text");
        assertEquals("<tg-spoiler>spoiler text</tg-spoiler> ", builder.toString());
    }
}
