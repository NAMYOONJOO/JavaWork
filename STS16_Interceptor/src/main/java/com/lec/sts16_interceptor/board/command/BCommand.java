package com.lec.sts16_interceptor.board.command;

import org.springframework.ui.Model;

public interface BCommand {
	void execute(Model model);
}
