package bll;

public class TransliterateCommand implements ICommand {
    private IEditorBO editorBO;
    private int pageId;
    private String arabicText;
    private String result;

    public TransliterateCommand(IEditorBO editorBO, int pageId, String arabicText) {
        this.editorBO = editorBO;
        this.pageId = pageId;
        this.arabicText = arabicText;
    }

    @Override
    public void execute() {
        this.result = editorBO.transliterate(pageId, arabicText);
    }

    public String getResult() {
        return result;
    }
}
