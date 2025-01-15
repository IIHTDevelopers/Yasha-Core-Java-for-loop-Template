package testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.stmt.ForStmt;

public class AutoGrader {

    // Test if the code uses only for loop and not while or do-while loops
    public boolean testForLoopOnly(String filePath) throws IOException {
        System.out.println("Starting testForLoopOnly with file: " + filePath);

        File participantFile = new File(filePath); // Path to participant's file
        if (!participantFile.exists()) {
            System.out.println("File does not exist at path: " + filePath);
            return false;
        }

        FileInputStream fileInputStream = new FileInputStream(participantFile);
        JavaParser javaParser = new JavaParser();
        CompilationUnit cu;
        try {
            cu = javaParser.parse(fileInputStream).getResult()
                    .orElseThrow(() -> new IOException("Failed to parse the Java file"));
        } catch (IOException e) {
            System.out.println("Error parsing the file: " + e.getMessage());
            throw e;
        }

        System.out.println("Parsed the Java file successfully.");

        boolean hasForLoop = false;

        // Log the parsed for loop statements
        System.out.println("------ for Loop Statements ------");
        for (ForStmt forStmt : cu.findAll(ForStmt.class)) {
            System.out.println("for loop found: " + forStmt);
            hasForLoop = true;
        }

        // Check if only for loop is used and no 'while' or 'do-while'
        System.out.println("Has for loop: " + hasForLoop);

        boolean result = hasForLoop;
        System.out.println("Test result: " + result);

        return result;
    }
}
