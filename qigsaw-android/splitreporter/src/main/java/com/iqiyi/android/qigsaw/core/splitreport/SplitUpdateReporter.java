/*
 * MIT License
 *
 * Copyright (c) 2019-present, iQIYI, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.iqiyi.android.qigsaw.core.splitreport;

import java.util.List;

/**
 * report update status of split APKs, called in main process.
 */
public interface SplitUpdateReporter {

    /**
     * When split-info version is updated, this method would be invoked.
     * You can kill main process in this method.
     *
     * @param oldSplitInfoVersion last version of split info file.
     * @param newSplitInfoVersion new version of split info file.
     * @param updateSplits        splits need be updated
     */
    void onUpdateOK(String oldSplitInfoVersion, String newSplitInfoVersion, List<String> updateSplits);

    /**
     * Called when updating failed
     *
     * @param oldSplitInfoVersion last version of split info file.
     * @param newSplitInfoVersion new version of split info file.
     * @param errorCode           {@link SplitUpdateErrorCode}
     */
    void onUpdateFailed(String oldSplitInfoVersion, String newSplitInfoVersion, int errorCode);

    /**
     * Called when new split info version loaded.
     *
     * @param newSplitInfoVersion new version of split info file.
     */
    void onNewSplitInfoVersionLoaded(String newSplitInfoVersion);

}
