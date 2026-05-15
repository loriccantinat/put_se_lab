package put.io.testing.mocks;

import put.io.students.fancylibrary.database.IFancyDatabase;
import java.util.*;

public class MyDatabase implements IFancyDatabase {

    @Override
    public <T> List<T> queryAll() {
        return Collections.emptyList();
    }

    @Override
    public void connect() {

    }

    @Override
    public void close() {

    }

    @Override
    public void persist(Object o){

    }
}