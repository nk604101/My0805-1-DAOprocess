package com.work.hsinwei.my0805_1_daoprocess;

import java.util.List;

/**
 * Created by Hsinwei on 2016/8/4.
 */
public interface dataInfoDAO {
    public void addDataInfo(dataInfo d);
    public void delDataInfo(dataInfo d);
    public void updtaeDataInfo(dataInfo d);
    public List getAllDataInfo();
}
