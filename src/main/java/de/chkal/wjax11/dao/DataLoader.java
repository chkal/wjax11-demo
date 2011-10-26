package de.chkal.wjax11.dao;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.enterprise.context.ApplicationScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;

@ApplicationScoped
public class DataLoader {

    private static AtomicBoolean initialized = new AtomicBoolean(false);

    public void checkDatabaseInitialized() {

        // run only once
        boolean success = initialized.compareAndSet(false, true);
        if (!success) {
            return;
        }

        try {

            // get a connection to the in-memory database
            IDatabaseConnection connection = new DatabaseDataSourceConnection(new InitialContext(),
                    "java:jboss/datasources/ExampleDS");
            connection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());

            // read the dataset
            InputStream datasetStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("dataset.xml");
            IDataSet dataset = new FlatXmlDataSetBuilder().build(datasetStream);

            // delete everything and do a new insert
            DatabaseOperation.CLEAN_INSERT.execute(connection, dataset);

        } catch (NamingException e) {
            throw new IllegalArgumentException(e);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        } catch (DataSetException e) {
            throw new IllegalArgumentException(e);
        } catch (DatabaseUnitException e) {
            throw new IllegalArgumentException(e);
        }

    }
}
