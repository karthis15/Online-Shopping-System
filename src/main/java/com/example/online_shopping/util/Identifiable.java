package com.example.online_shopping.util;

import java.io.Serializable;

public interface Identifiable<T extends Serializable> {

	T getId();

	T getPrefix();
	
	T getStringFormat();
}
