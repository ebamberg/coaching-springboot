package com.ebamberg.coaching.demos.springdata.repositories.bulksave;


import java.util.List;

public interface BulkSaveDAO<T> {

  public void bulkDataSave(List<T> bulkDataList);

}
