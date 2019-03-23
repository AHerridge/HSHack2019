package com.fidohealth.fido;

import android.os.health.HealthStats

private class VerifyDataTask extends AsyncTask<Void, Void, Void> {
    protected Void doInBackground(Void... params) {

        long total = 0;

        PendingResult<DailyTotalResult> result = Fitness.HistoryApi.readDailyTotal(mClient, DataType.TYPE_STEP_COUNT_DELTA);
        DailyTotalResult totalResult = result.await(30, TimeUnit.SECONDS);
        if (totalResult.getStatus().isSuccess()) {
            DataSet totalSet = totalResult.getTotal();
            total = totalSet.isEmpty()
                    ? 0
                    : totalSet.getDataPoints().get(0).getValue(Field.FIELD_STEPS).asInt();
        } else {
            Log.w(TAG, "There was a problem getting the step count.");
        }

        Log.i(TAG, "Total steps: " + total);

        return null;
    }
}

    final DataSource ds = new DataSource.Builder()
            .setAppPackageName("com.google.android.gms")
            .setDataType(DataType.TYPE_STEP_COUNT_DELTA)
            .setType(DataSource.TYPE_DERIVED)
            .setStreamName("estimated_steps")
            .build();

    final DataReadRequest req = new DataReadRequest.Builder()
            .aggregate(ds, DataType.AGGREGATE_STEP_COUNT_DELTA)
            .bucketByTime(1, TimeUnit.DAYS)
            .setTimeRange(timeBounds[0], timeBounds[1], TimeUnit.MILLISECONDS)
            .build();

