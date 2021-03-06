package com.neusoft.oddc.db.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.neusoft.oddc.db.dbentity.UserProfileEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER_PROFILE_ENTITY".
*/
public class UserProfileEntityDao extends AbstractDao<UserProfileEntity, Long> {

    public static final String TABLENAME = "USER_PROFILE_ENTITY";

    /**
     * Properties of entity UserProfileEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Key_user = new Property(1, String.class, "key_user", false, "KEY_USER");
        public final static Property Username = new Property(2, String.class, "username", false, "USERNAME");
        public final static Property Firstname = new Property(3, String.class, "firstname", false, "FIRSTNAME");
        public final static Property Lastname = new Property(4, String.class, "lastname", false, "LASTNAME");
        public final static Property Phoneno = new Property(5, String.class, "phoneno", false, "PHONENO");
        public final static Property Email = new Property(6, String.class, "email", false, "EMAIL");
        public final static Property Driverlicenseno = new Property(7, String.class, "driverlicenseno", false, "DRIVERLICENSENO");
    }


    public UserProfileEntityDao(DaoConfig config) {
        super(config);
    }
    
    public UserProfileEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER_PROFILE_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"KEY_USER\" TEXT," + // 1: key_user
                "\"USERNAME\" TEXT," + // 2: username
                "\"FIRSTNAME\" TEXT," + // 3: firstname
                "\"LASTNAME\" TEXT," + // 4: lastname
                "\"PHONENO\" TEXT," + // 5: phoneno
                "\"EMAIL\" TEXT," + // 6: email
                "\"DRIVERLICENSENO\" TEXT);"); // 7: driverlicenseno
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER_PROFILE_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, UserProfileEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String key_user = entity.getKey_user();
        if (key_user != null) {
            stmt.bindString(2, key_user);
        }
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(3, username);
        }
 
        String firstname = entity.getFirstname();
        if (firstname != null) {
            stmt.bindString(4, firstname);
        }
 
        String lastname = entity.getLastname();
        if (lastname != null) {
            stmt.bindString(5, lastname);
        }
 
        String phoneno = entity.getPhoneno();
        if (phoneno != null) {
            stmt.bindString(6, phoneno);
        }
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(7, email);
        }
 
        String driverlicenseno = entity.getDriverlicenseno();
        if (driverlicenseno != null) {
            stmt.bindString(8, driverlicenseno);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, UserProfileEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String key_user = entity.getKey_user();
        if (key_user != null) {
            stmt.bindString(2, key_user);
        }
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(3, username);
        }
 
        String firstname = entity.getFirstname();
        if (firstname != null) {
            stmt.bindString(4, firstname);
        }
 
        String lastname = entity.getLastname();
        if (lastname != null) {
            stmt.bindString(5, lastname);
        }
 
        String phoneno = entity.getPhoneno();
        if (phoneno != null) {
            stmt.bindString(6, phoneno);
        }
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(7, email);
        }
 
        String driverlicenseno = entity.getDriverlicenseno();
        if (driverlicenseno != null) {
            stmt.bindString(8, driverlicenseno);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public UserProfileEntity readEntity(Cursor cursor, int offset) {
        UserProfileEntity entity = new UserProfileEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // key_user
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // username
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // firstname
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // lastname
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // phoneno
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // email
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7) // driverlicenseno
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, UserProfileEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setKey_user(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUsername(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setFirstname(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setLastname(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setPhoneno(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setEmail(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setDriverlicenseno(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(UserProfileEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(UserProfileEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(UserProfileEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
