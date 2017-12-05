package com.tg.util;

import java.util.Properties;


/**
 * 解密用户名和密码
 */
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptPlaceholderConfigure extends PropertyPlaceholderConfigurer {
	
	//需要解密的字符串
	private String[] encryptPropName = {"jdbc.username","jdbc.password"};
	@Override
	protected String resolvePlaceholder(String placeholder, Properties props, int systemPropertiesMode) {
		if(isEncrytProp(placeholder))
		{
			return DESUtils.getDecryptString(props.getProperty(placeholder));
		}else{
			String propVal = null;
			if (systemPropertiesMode == SYSTEM_PROPERTIES_MODE_OVERRIDE) {
				propVal = resolveSystemProperty(placeholder);
			}
			if (propVal == null) {
				propVal = resolvePlaceholder(placeholder, props);
			}
			if (propVal == null && systemPropertiesMode == SYSTEM_PROPERTIES_MODE_FALLBACK) {
				propVal = resolveSystemProperty(placeholder);
			}
			return propVal;
		}
	}
	private boolean isEncrytProp(String propertyName)
	{
		for(String encryptName : encryptPropName)
		{
			if(encryptName.equals(propertyName))
			{
				return true;
			}
		}
		return false;
	}

}
