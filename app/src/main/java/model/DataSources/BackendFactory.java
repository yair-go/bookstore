package model.DataSources;

import android.content.Context;

import java.lang.String;import model.backend.Backend;

/**
 * Created by haim on 3/23/15.
 */
public class BackendFactory {
    static Backend instance = null;

    public static String mode = "sqlite";

    public final static Backend getInstance(Context context)
    {
        if (mode == "lists")
        {
            if (instance == null)
                instance = new model.DataSources.DatabaseList(context);
            return instance;
        }

        if (mode == "sqlite")
        {
            if (instance == null)
                instance = new model.DataSources.DatabaseSqlite(context);
            return instance;
        }

        if (mode == "mysql")
        {
            if (instance == null)
                instance = new model.DataSources.DatabaseMySQL(context);
            return instance;
        }
        else return null;
    }
}
