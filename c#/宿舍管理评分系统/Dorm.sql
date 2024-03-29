USE [Dorm]
GO
/****** Object:  Table [dbo].[dormitorys]    Script Date: 2022/12/14 1:32:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[dormitorys](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[dormitory] [int] NULL,
	[no1] [int] NULL,
	[no2] [int] NULL,
	[no3] [int] NULL,
	[no4] [int] NULL,
 CONSTRAINT [PK_dormitorys] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[dormScroe]    Script Date: 2022/12/14 1:32:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[dormScroe](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[dorm] [int] NULL,
	[bedScroe] [int] NULL,
	[sanitationScroe] [int] NULL,
	[disciplineScroe] [int] NULL,
	[scroe] [int] NULL,
 CONSTRAINT [PK_dormScroe] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Manage]    Script Date: 2022/12/14 1:32:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Manage](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nchar](10) NULL,
	[number] [int] NULL,
	[duty] [nchar](10) NULL,
	[password] [nchar](10) NULL,
 CONSTRAINT [PK_Manage] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[students]    Script Date: 2022/12/14 1:32:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[students](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[number] [int] NULL,
	[name] [nchar](10) NULL,
	[dorm] [int] NULL,
	[bedNumber] [int] NULL,
 CONSTRAINT [PK_students] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
