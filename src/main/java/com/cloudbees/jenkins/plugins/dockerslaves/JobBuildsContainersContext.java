/*
 * The MIT License
 *
 *  Copyright (c) 2015, CloudBees, Inc.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 *
 */

package com.cloudbees.jenkins.plugins.dockerslaves;

import hudson.model.BuildBadgeAction;

import java.util.ArrayList;
import java.util.List;

public class JobBuildsContainersContext implements BuildBadgeAction {

    protected ContainerInstance remotingContainer;

    protected List<ContainerInstance> buildContainers = new ArrayList<ContainerInstance>();

    protected List<ContainerInstance> sideContainers = new ArrayList<ContainerInstance>();

    /**
     * Flag to indicate the SCM checkout build phase is running.
     */
    private transient boolean preScm;

    public JobBuildsContainersContext() {
        preScm = true;
    }

    protected void onScmChekoutCompleted() {
        preScm = false;
    }

    public ContainerInstance getRemotingContainer() {
        return remotingContainer;
    }

    public List<ContainerInstance> getBuildContainers() {
        return buildContainers;
    }

    public boolean isPreScm() {
        return preScm;
    }

    public void setRemotingContainer(ContainerInstance remotingContainer) {
        this.remotingContainer = remotingContainer;
    }

    public List<ContainerInstance> getSideContainers() {
        return sideContainers;
    }

    public void setSideContainers(List<ContainerInstance> sideContainers) {
        this.sideContainers = sideContainers;
    }

    @Override
    public String getIconFileName() {
        return "/plugin/container-slaves/images/24x24/docker-logo.png";
    }

    @Override
    public String getDisplayName() {
        return "Docker Build Context";
    }

    @Override
    public String getUrlName() {
        return "docker";
    }
}
