package org.mcal.moddedpe_new.utils;

import android.content.Context;

import org.mcal.moddedpe_new.ModdedPEApplication;
import org.mcal.pesdk.PESdk;

public class DataPreloader
{
	private PreloadingFinishedListener mListener;
	private boolean mIsSleepingFinished = false;
	private boolean mIsPreloadingFinished = false;

	public DataPreloader(PreloadingFinishedListener litenser)
	{
		mListener = litenser;
	}

	public void preload(Context context_a)
	{
		final Context context = context_a;
		new Thread()
		{
			public void run()
			{
				ModdedPEApplication.mPESdk = new PESdk(context,new UtilsSettings(context));
				ModdedPEApplication.mPESdk.init();
				mIsPreloadingFinished = true;
				checkFinish();
			}
		}.start();

		new Thread()
		{
			public void run()
			{
				try
				{
					Thread.sleep(5000);
				}
				catch (InterruptedException e)
				{}
				mIsSleepingFinished = true;
				checkFinish();
			}
		}.start();
	}

	private void checkFinish()
	{
		if (mIsPreloadingFinished && mIsSleepingFinished)
			mListener.onPreloadingFinished();
	}

	public abstract interface PreloadingFinishedListener
	{
		void onPreloadingFinished();
	}
}
