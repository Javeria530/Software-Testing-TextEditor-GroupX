package bll;

import java.io.File;

public class ImportCommand implements ICommand {
    private IEditorBO editorBO;
    private File file;
    private String fileName;
    private boolean result;

    public ImportCommand(IEditorBO editorBO, File file, String fileName) {
        this.editorBO = editorBO;
        this.file = file;
        this.fileName = fileName;
    }

    @Override
    public void execute() {
        this.result = editorBO.importTextFiles(file, fileName);
    }

    public boolean getResult() {
        return result;
    }
}
