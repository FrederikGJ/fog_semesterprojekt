package dat.backend.model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;


import dat.backend.model.entities.entities.CalculateBOM;
import dat.backend.model.entities.entities.Materials;
import dat.backend.model.entities.exceptions.DatabaseException;
import dat.backend.model.entities.persistence.AdminFacade;
import dat.backend.model.entities.persistence.ConnectionPool;

import org.junit.jupiter.api.Test;

import java.util.List;

class CalculateBOMTest {

    //unit test of non-complex funcitons in the CalculateBOM class.

    @Test
    public void testBeamWidthCalculator() {
        CalculateBOM calculateBOM = new CalculateBOM();
        assertEquals(300, calculateBOM.beamWidthCalculator(300));
        assertEquals(300, calculateBOM.beamWidthCalculator(250));
        assertEquals(360, calculateBOM.beamWidthCalculator(350));
        assertEquals(420, calculateBOM.beamWidthCalculator(400));
        assertEquals(480, calculateBOM.beamWidthCalculator(470));
        assertEquals(540, calculateBOM.beamWidthCalculator(500));
    }

    @Test
    public void testBeamLengthCalculator() {
        CalculateBOM calculateBOM = new CalculateBOM();
        assertEquals(300, calculateBOM.beamLengthCalculator(300));
        assertEquals(300, calculateBOM.beamLengthCalculator(250));
        assertEquals(360, calculateBOM.beamLengthCalculator(350));
        assertEquals(420, calculateBOM.beamLengthCalculator(400));
        assertEquals(480, calculateBOM.beamLengthCalculator(470));
        assertEquals(540, calculateBOM.beamLengthCalculator(500));
    }

    @Test
    public void testRafterLengthCalculator() {
        CalculateBOM calculateBOM = new CalculateBOM();
        assertEquals(300, calculateBOM.raftLengthCalculator(300));
        assertEquals(300, calculateBOM.raftLengthCalculator(250));
        assertEquals(360, calculateBOM.raftLengthCalculator(350));
        assertEquals(420, calculateBOM.raftLengthCalculator(400));
        assertEquals(480, calculateBOM.raftLengthCalculator(470));
        assertEquals(540, calculateBOM.raftLengthCalculator(500));
    }

    @Test
    public void testFindMaterialByName() throws DatabaseException
    {
        String name = "skruer";
        ConnectionPool connectionPool = new ConnectionPool();
        List<Materials> materials = AdminFacade.getAllMaterials(connectionPool);
        CalculateBOM calculateBOM = new CalculateBOM();
        Materials material = calculateBOM.findMaterialByName(name, materials);
        assertEquals(name, material.getName());
    }

    @Test
    public void testFindMaterialByNameAndLength() throws DatabaseException {
        String name = "spær";
        int length = 600;
        ConnectionPool connectionPool = new ConnectionPool();
        List<Materials> materials = AdminFacade.getAllMaterials(connectionPool);
        CalculateBOM calculateBOM = new CalculateBOM();
        Materials material = calculateBOM.findMaterialByNameAndLength(name, length, materials);
        assertEquals(name, material.getName());
    }

    @Test
    public void testPostQuantityCalculator() {
        CalculateBOM calculateBOM = new CalculateBOM();

        //Test case for when length > 450
        int result1 = calculateBOM.postQuantityCalculator(500, 100);
        assertEquals(6, result1, "Expected quantity of posts: 6");

        //Test case for when width > 450
        int result2 = calculateBOM.postQuantityCalculator(100, 500);
        assertEquals(6, result2, "Expected quantity of posts: 6");

        //Test case for when both length and width <= 450
        int result3 = calculateBOM.postQuantityCalculator(400, 400);
        assertEquals(4, result3, "Expected quantity of posts: 4");
    }

    @Test
    public void testRaftQuantityCalculator() {
        CalculateBOM calculateBOM = new CalculateBOM();

        int result1 = calculateBOM.raftQuantityCalculator(500);
        assertEquals(9, result1, "Expected quantity of rafts: 9");


        int result2 = calculateBOM.raftQuantityCalculator(450);
        assertEquals(8, result2, "Expected quantity of rafts: 8");

        //Test case for lower boundary
        int result3 = calculateBOM.raftQuantityCalculator(300);
        assertEquals(5, result3, "Expected quantity of rafts: 5");


        int result4 = calculateBOM.raftQuantityCalculator(600);
        assertEquals(11, result4, "Expected quantity of rafts: 11");
    }



}