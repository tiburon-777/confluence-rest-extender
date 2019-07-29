package su.tiburon.atlassian.confluence.impl;

import java.util.Date;

import javax.inject.Named;

import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;

import su.tiburon.atlassian.confluence.api.DateTimeUtil;

@ExportAsService
@Named
public class DateTimeUtilImpl implements DateTimeUtil {

    @Override
    public Date getDate() {
        return new Date();
    }


}
