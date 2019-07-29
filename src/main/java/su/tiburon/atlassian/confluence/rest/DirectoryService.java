package su.tiburon.atlassian.confluence.rest;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atlassian.confluence.security.PermissionManager;
import com.atlassian.confluence.user.AuthenticatedUserThreadLocal;
import com.atlassian.confluence.user.ConfluenceUser;
import com.atlassian.plugin.spring.scanner.annotation.imports.ConfluenceImport;
import com.atlassian.plugins.rest.common.security.AnonymousAllowed;
import com.atlassian.crowd.embedded.api.CrowdDirectoryService;
import com.atlassian.crowd.embedded.api.Directory;

@Path("/directory")
@AnonymousAllowed
@Produces(MediaType.APPLICATION_JSON)
public class DirectoryService {
    private static final Logger logger = LoggerFactory.getLogger(DirectoryService.class);

    @ConfluenceImport
    private final PermissionManager permissionManager;

    @ConfluenceImport
    private final CrowdDirectoryService crowdDirectoryService;

    @Inject
    public DirectoryService(PermissionManager permissionManager, CrowdDirectoryService crowdDirectoryService) {
        this.permissionManager = permissionManager;
        this.crowdDirectoryService = crowdDirectoryService;
    }

    @GET
    public Response getDir() {
        // Authentication
        ConfluenceUser loggedInAppUser = AuthenticatedUserThreadLocal.get();
        if (!this.permissionManager.isConfluenceAdministrator(loggedInAppUser)) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ErrorModel("401 Unauthorized", "Confluence Administrator Permission required!")).build();
        }
        logger.info(MessageFormat.format("User({0}) requesting infodmation about CUDs", new Object[] {loggedInAppUser.getName() }));

        Collection<DirectoryModel> coll = new ArrayList<DirectoryModel>();

        for (Directory dsa : crowdDirectoryService.findAllDirectories()) {
            coll.add(new DirectoryModel(dsa.getId(),dsa.getType(),crowdDirectoryService.isDirectorySynchronising(dsa.getId())));
        }
        return Response.ok(coll).build();
    }

    @PUT
    public Response syncDir(@QueryParam("id") Long dirId) {
        
        // Authentication
        ConfluenceUser loggedInAppUser = AuthenticatedUserThreadLocal.get();
        if (!this.permissionManager.isConfluenceAdministrator(loggedInAppUser)) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ErrorModel("401 Unauthorized", "Confluence Administrator Permission required!")).build();
        }

        crowdDirectoryService.synchroniseDirectory(dirId, true);
        
        Collection<DirectoryModel> coll = new ArrayList<DirectoryModel>();

        for (Directory dsa : crowdDirectoryService.findAllDirectories()) {
            coll.add(new DirectoryModel(dsa.getId(),dsa.getType(),crowdDirectoryService.isDirectorySynchronising(dsa.getId())));
        }
        return Response.ok(coll).build();
    }
}