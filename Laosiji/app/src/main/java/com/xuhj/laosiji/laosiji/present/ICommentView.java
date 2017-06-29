package com.xuhj.laosiji.laosiji.present;

/**
 * Created by xuhj on 2017/6/28.
 */

public interface ICommentView {
	public void showWait(String info);
	public void showMsg(String info);
	public void showError(String info);
	public void showToast(String info);
}
