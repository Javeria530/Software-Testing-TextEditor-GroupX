package bll;

public class ExportCommand implements ICommand {
    private IEditorBO editorBO;
    private int fileId;
    private String fileName;
    private int pageNumber;
    private String content;
    private boolean result;

    public ExportCommand(IEditorBO editorBO, int fileId, String fileName, int pageNumber, String content) {
        this.editorBO = editorBO;
        this.fileId = fileId;
        this.fileName = fileName;
        this.pageNumber = pageNumber;
        this.content = content;
    }

    @Override
    public void execute() {
        this.result = editorBO.updateFile(fileId, fileName, pageNumber, content);
    }

    public boolean getResult() {
        return result;
    }
}
