package Controller;

import Model.Aluno;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ControleAlunoTest {

    public ControleAlunoTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of inserirAluno method, of class ControleAluno.
     */
    @Test
    public void testInserirAluno() {
        System.out.println("inserirAluno");
        Aluno aluno = new Aluno("Thiago Fernandes Ribeiro", "120160", "08462311900", "43996069321", "Av dos Pinheiros, 220");;
        ControleAluno instance = new ControleAluno();
        instance.inserirAluno(aluno);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluirAluno method, of class ControleAluno.
     */
//    @Test
//    public void testExcluirAluno() {
//        System.out.println("excluirAluno");
//        Aluno aluno = null;
//        ControleAluno instance = new ControleAluno();
//        boolean expResult = false;
//        boolean result = instance.excluirAluno(aluno);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of verificarAluno method, of class ControleAluno.
     */
    @Test
    public void testVerificarAluno() {
        System.out.println("verificarAluno");
        Aluno aluno = null;
        ControleAluno instance = new ControleAluno();
        boolean expResult = false;
        boolean result = instance.verificarAluno(aluno);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
