package ar.com.scriptorum.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.com.scriptorum.beans.CUnit;
import au.com.bytecode.opencsv.CSVWriter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:appContext.xml")
public class UnitsReporterTest implements Reporter<CUnit> {

    @Autowired
    PUTransformer transformer;

    private Location location;
    private List<String[]> csvAbles;
    private List<CUnit> units;

    @Override
    public Reporter<CUnit> createReport() {
        this.csvAbles = this.transform(units);
        return this;
    }

    public List<String[]> transform(List<CUnit> units) {
        return new CuTransformer<CUnit>(units).toCsvs();
    }

    @Override
    public Reporter<CUnit> writeIn(Location location) {
        this.location = location;
        return this;
    }

    @Override
    public Reporter<CUnit> asCsv() {

        CSVWriter w;
        try {
            w = new CSVWriter(new BufferedWriter(new FileWriter(reportName(), true)));

            w.writeAll(csvAbles);
            w.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this;
    }

    private String reportName() {
        return this.location.asString() + new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date()) + ".csv";
    }

    @Test
    public void test() {

        try {
            Location wrkspace = new WorkspaceLocation();
            Location reports = new ReportsLocation();
            units = new UnitsFileLoader(wrkspace).load();
            assertNotNull(units);
            createReport().writeIn(reports).asCsv().saved();
            
        } catch (Throwable t) {
            fail("unexpected error " + t);
        }
    }

    public Reporter<CUnit> saved() {

        for (CUnit unit : units) {
            transformer.asPUnit(unit);
        }
        return this;
    }

}
