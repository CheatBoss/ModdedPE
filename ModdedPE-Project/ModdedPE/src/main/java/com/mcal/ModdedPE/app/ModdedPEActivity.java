package com.mcal.ModdedPE.app;
import com.mcal.MCDesign.app.*;
import com.mcal.ModdedPE.*;
import com.mcal.pesdk.nmod.*;
import com.mcal.pesdk.*;

public class ModdedPEActivity extends MCDActivity
{
	protected PESdk getPESdk()
	{
		return ModdedPEApplication.mPESdk;
	}
}
