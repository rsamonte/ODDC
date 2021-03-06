package com.neusoft.oddc.db.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.neusoft.oddc.db.dbentity.ADASParametersEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ADASPARAMETERS_ENTITY".
*/
public class ADASParametersEntityDao extends AbstractDao<ADASParametersEntity, Long> {

    public static final String TABLENAME = "ADASPARAMETERS_ENTITY";

    /**
     * Properties of entity ADASParametersEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Key_user = new Property(1, String.class, "key_user", false, "KEY_USER");
        public final static Property Gps_frequency = new Property(2, String.class, "gps_frequency", false, "GPS_FREQUENCY");
        public final static Property Ld_sensor_sensitivity = new Property(3, int.class, "ld_sensor_sensitivity", false, "LD_SENSOR_SENSITIVITY");
        public final static Property Fwd_col_sensitivity = new Property(4, int.class, "fwd_col_sensitivity", false, "FWD_COL_SENSITIVITY");
        public final static Property Accelerometer_sensitivity = new Property(5, String.class, "accelerometer_sensitivity", false, "ACCELEROMETER_SENSITIVITY");
        public final static Property Vehicle_length = new Property(6, int.class, "vehicle_length", false, "VEHICLE_LENGTH");
        public final static Property Vehicle_width = new Property(7, int.class, "vehicle_width", false, "VEHICLE_WIDTH");
        public final static Property Vehicle_height = new Property(8, int.class, "vehicle_height", false, "VEHICLE_HEIGHT");
        public final static Property Camera_fov = new Property(9, String.class, "camera_fov", false, "CAMERA_FOV");
        public final static Property Wheelbase = new Property(10, String.class, "wheelbase", false, "WHEELBASE");
        public final static Property Curb_weight = new Property(11, String.class, "curb_weight", false, "CURB_WEIGHT");
        public final static Property Camera_ht_from_ground = new Property(12, int.class, "camera_ht_from_ground", false, "CAMERA_HT_FROM_GROUND");
        public final static Property Camera_offset_from_center = new Property(13, int.class, "camera_offset_from_center", false, "CAMERA_OFFSET_FROM_CENTER");
        public final static Property Camera_dist_from_front = new Property(14, int.class, "camera_dist_from_front", false, "CAMERA_DIST_FROM_FRONT");
    }


    public ADASParametersEntityDao(DaoConfig config) {
        super(config);
    }
    
    public ADASParametersEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ADASPARAMETERS_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"KEY_USER\" TEXT," + // 1: key_user
                "\"GPS_FREQUENCY\" TEXT," + // 2: gps_frequency
                "\"LD_SENSOR_SENSITIVITY\" INTEGER NOT NULL ," + // 3: ld_sensor_sensitivity
                "\"FWD_COL_SENSITIVITY\" INTEGER NOT NULL ," + // 4: fwd_col_sensitivity
                "\"ACCELEROMETER_SENSITIVITY\" TEXT," + // 5: accelerometer_sensitivity
                "\"VEHICLE_LENGTH\" INTEGER NOT NULL ," + // 6: vehicle_length
                "\"VEHICLE_WIDTH\" INTEGER NOT NULL ," + // 7: vehicle_width
                "\"VEHICLE_HEIGHT\" INTEGER NOT NULL ," + // 8: vehicle_height
                "\"CAMERA_FOV\" TEXT," + // 9: camera_fov
                "\"WHEELBASE\" TEXT," + // 10: wheelbase
                "\"CURB_WEIGHT\" TEXT," + // 11: curb_weight
                "\"CAMERA_HT_FROM_GROUND\" INTEGER NOT NULL ," + // 12: camera_ht_from_ground
                "\"CAMERA_OFFSET_FROM_CENTER\" INTEGER NOT NULL ," + // 13: camera_offset_from_center
                "\"CAMERA_DIST_FROM_FRONT\" INTEGER NOT NULL );"); // 14: camera_dist_from_front
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ADASPARAMETERS_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ADASParametersEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String key_user = entity.getKey_user();
        if (key_user != null) {
            stmt.bindString(2, key_user);
        }
 
        String gps_frequency = entity.getGps_frequency();
        if (gps_frequency != null) {
            stmt.bindString(3, gps_frequency);
        }
        stmt.bindLong(4, entity.getLd_sensor_sensitivity());
        stmt.bindLong(5, entity.getFwd_col_sensitivity());
 
        String accelerometer_sensitivity = entity.getAccelerometer_sensitivity();
        if (accelerometer_sensitivity != null) {
            stmt.bindString(6, accelerometer_sensitivity);
        }
        stmt.bindLong(7, entity.getVehicle_length());
        stmt.bindLong(8, entity.getVehicle_width());
        stmt.bindLong(9, entity.getVehicle_height());
 
        String camera_fov = entity.getCamera_fov();
        if (camera_fov != null) {
            stmt.bindString(10, camera_fov);
        }
 
        String wheelbase = entity.getWheelbase();
        if (wheelbase != null) {
            stmt.bindString(11, wheelbase);
        }
 
        String curb_weight = entity.getCurb_weight();
        if (curb_weight != null) {
            stmt.bindString(12, curb_weight);
        }
        stmt.bindLong(13, entity.getCamera_ht_from_ground());
        stmt.bindLong(14, entity.getCamera_offset_from_center());
        stmt.bindLong(15, entity.getCamera_dist_from_front());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ADASParametersEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String key_user = entity.getKey_user();
        if (key_user != null) {
            stmt.bindString(2, key_user);
        }
 
        String gps_frequency = entity.getGps_frequency();
        if (gps_frequency != null) {
            stmt.bindString(3, gps_frequency);
        }
        stmt.bindLong(4, entity.getLd_sensor_sensitivity());
        stmt.bindLong(5, entity.getFwd_col_sensitivity());
 
        String accelerometer_sensitivity = entity.getAccelerometer_sensitivity();
        if (accelerometer_sensitivity != null) {
            stmt.bindString(6, accelerometer_sensitivity);
        }
        stmt.bindLong(7, entity.getVehicle_length());
        stmt.bindLong(8, entity.getVehicle_width());
        stmt.bindLong(9, entity.getVehicle_height());
 
        String camera_fov = entity.getCamera_fov();
        if (camera_fov != null) {
            stmt.bindString(10, camera_fov);
        }
 
        String wheelbase = entity.getWheelbase();
        if (wheelbase != null) {
            stmt.bindString(11, wheelbase);
        }
 
        String curb_weight = entity.getCurb_weight();
        if (curb_weight != null) {
            stmt.bindString(12, curb_weight);
        }
        stmt.bindLong(13, entity.getCamera_ht_from_ground());
        stmt.bindLong(14, entity.getCamera_offset_from_center());
        stmt.bindLong(15, entity.getCamera_dist_from_front());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public ADASParametersEntity readEntity(Cursor cursor, int offset) {
        ADASParametersEntity entity = new ADASParametersEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // key_user
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // gps_frequency
            cursor.getInt(offset + 3), // ld_sensor_sensitivity
            cursor.getInt(offset + 4), // fwd_col_sensitivity
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // accelerometer_sensitivity
            cursor.getInt(offset + 6), // vehicle_length
            cursor.getInt(offset + 7), // vehicle_width
            cursor.getInt(offset + 8), // vehicle_height
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // camera_fov
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // wheelbase
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // curb_weight
            cursor.getInt(offset + 12), // camera_ht_from_ground
            cursor.getInt(offset + 13), // camera_offset_from_center
            cursor.getInt(offset + 14) // camera_dist_from_front
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ADASParametersEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setKey_user(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setGps_frequency(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setLd_sensor_sensitivity(cursor.getInt(offset + 3));
        entity.setFwd_col_sensitivity(cursor.getInt(offset + 4));
        entity.setAccelerometer_sensitivity(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setVehicle_length(cursor.getInt(offset + 6));
        entity.setVehicle_width(cursor.getInt(offset + 7));
        entity.setVehicle_height(cursor.getInt(offset + 8));
        entity.setCamera_fov(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setWheelbase(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setCurb_weight(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setCamera_ht_from_ground(cursor.getInt(offset + 12));
        entity.setCamera_offset_from_center(cursor.getInt(offset + 13));
        entity.setCamera_dist_from_front(cursor.getInt(offset + 14));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ADASParametersEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ADASParametersEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ADASParametersEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
